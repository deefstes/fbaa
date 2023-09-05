package wiz.fbaa.branchclient.grpc;

import com.google.protobuf.Empty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import wiz.fbaa.branchclient.branch.BranchConfig;
import wiz.fbaa.branchclient.branch.CreatureData;

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
        CreatureData creatureData = getRandomCreatureForBranch(branch);

        if (creatureData == null) {
            log.info("Branch [{}] could not find any creatures at this time.", branch.getName());
            log.info("All done!\n\n");
            return;
        }

        log.info("Branch [{}] is reserving creature [{}].", branch.getName(), creatureData.getName());
        branchReserveCreature(branch, creatureData);

        log.info("All done!\n\n");
    }

    private CreatureData getRandomCreatureForBranch(BranchConfig branch) {
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

        List<CreatureData> list = new ArrayList<>();

        // Large data lists or large data objects in a list require a lot of heap space
        // Streaming prevents the need of having to allocate so much space when querying large data.
        // We can either transform the large data object into something our microservice only requires
        // and save this into a list, or we can perform our business logic as the data object is retrieved.
        // The performance of iterating over each data object is dependent on the action(business logic)
        // required by the microservice.

        // We would probably need to perform some sort of paging if this was a rest service. What happens if the
        // rest service doesn't support paging.

        // Below we transform the creature response object into a creature data object which only contains the
        // id and name of the creature.
        while (it.hasNext()) {
            Fbaa.CreatureResponse creatureResponse = it.next();
            log.info("Found creature [{}].", creatureResponse.getName());
            list.add(new CreatureData(creatureResponse.getId(), creatureResponse.getName()));
        }

        if (list.isEmpty()) {
            return null;
        }

        CreatureData creatureData = list.get(random.nextInt(list.size()));
        log.info("Random creature chosen [{}].", creatureData.getName());

        return creatureData;
    }

    private void branchReserveCreature(BranchConfig branch, CreatureData creatureData) {
        Fbaa.ReserveCreatureRequest request = Fbaa.ReserveCreatureRequest.newBuilder()
                .setBranchId(branch.getName())
                .setId(creatureData.getId())
                .build();

        Empty empty = fbaaBlockingStub.reserveCreature(request);
    }


}
