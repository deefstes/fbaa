package wiz.fbaa.branchclient.grpc;

import com.google.protobuf.Empty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import wiz.fbaa.branchclient.branch.BranchConfig;

import java.util.*;

@RequiredArgsConstructor
@Component
@Slf4j
public class FBAAGrpcImpl {

    private final FBAAGrpc.FBAABlockingStub fbaaBlockingStub;
    private final Random random = new Random();

    public void randomlyReserveCreature() {
        BranchConfig branch = BranchConfig.getRandomBranch();
        log.info("Branch [{}] would like to reserve a creature.", branch.getName());

        log.info("Browsing the list from HQ");
        Fbaa.CreatureResponse creatureResponse = getRandomCreatureForBranch(branch);

        if (creatureResponse == null) {
            log.info("Branch [{}] could not find any creatures at this time.", branch.getName());
            log.info("All done!\n\n");
            return;
        }

        log.info("Branch [{}] is reserving creature [{}].", branch.getName(), creatureResponse.getName());
        branchReserveCreature(branch, creatureResponse);

        log.info("All done!\n\n");
    }

    private Fbaa.CreatureResponse getRandomCreatureForBranch(BranchConfig branch) {
        Fbaa.Rarity rarity = branch.getRandomRarity();
        log.info("Random rarity chosen [{}].", rarity.name());

        List<Fbaa.SpecialAbility> abilities = branch.getRandomAbilities();
        log.info("Random abilities chosen [{}].", abilities.isEmpty()? "Any" : abilities);

        Fbaa.StreamCreatureRequest request = Fbaa.StreamCreatureRequest.newBuilder()
                .setAvailable(true)
                .addRarity(rarity)
                .addAllAbility(abilities)
                .build();

        Iterator<Fbaa.CreatureResponse> it = fbaaBlockingStub.streamCreatures(request);

        List<Fbaa.CreatureResponse> list = new ArrayList<>();
        while (it.hasNext()) {
            Fbaa.CreatureResponse creatureResponse = it.next();
            log.info("Found creature [{}].", creatureResponse.getName());
            list.add(creatureResponse);
        }

        if (list.isEmpty()) {
            return null;
        }

        Fbaa.CreatureResponse creatureResponse = list.get(random.nextInt(list.size()));
        log.info("Random creature chosen [{}].", creatureResponse.getName());

        return creatureResponse;
    }

    private void branchReserveCreature(BranchConfig branch, Fbaa.CreatureResponse creatureResponse) {
        Fbaa.ReserveCreatureRequest request = Fbaa.ReserveCreatureRequest.newBuilder()
                .setBranchId(branch.getName())
                .setId(creatureResponse.getId())
                .build();

        Empty empty = fbaaBlockingStub.reserveCreature(request);
    }


}
