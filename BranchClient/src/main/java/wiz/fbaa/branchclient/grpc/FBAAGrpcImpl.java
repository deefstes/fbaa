package wiz.fbaa.branchclient.grpc;

import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
@Slf4j
public class FBAAGrpcImpl {

    private final FBAAGrpc.FBAABlockingStub fbaaBlockingStub;
    private Random random = new Random();

    private final List<String> branch = new ArrayList<String>(){{
        add("Hogwarts School of Witchcraft and Wizardry");
        add("Beauxbatons Academy of Magic");
        add("Durmstrang Institute");
        add("Mahoutokoro School of Magic");
    }};

    public void randomlyReserveCreature() {
        String branch = getRandomBranch();
        log.info("Branch [{}] would like to reserve a creature.", branch);

        log.info("Browsing the list from HQ");
        Fbaa.CreatureResponse creatureResponse = getRandomCreatureByAvailableAndRandomRarity();

        if (creatureResponse == null) {
            log.info("Branch [{}] could not find any creatures at this time", branch);
            log.info("All done!\n\n");
            return;
        }

        log.info("Branch [{}] is reserving creature [{}]", branch, creatureResponse.getName());
        branchReserveCreature(branch, creatureResponse);

        log.info("All done!\n\n");
    }

    private String getRandomBranch() {
        int branchInt = random.nextInt(branch.size());
        return branch.get(branchInt);
    }

    private Fbaa.CreatureResponse getRandomCreatureByAvailableAndRandomRarity() {
        int rarityInt = random.nextInt((4));
        Fbaa.Rarity rarity = Fbaa.Rarity.forNumber(rarityInt);
        log.info("Random rarity chosen [{}]", rarity.name());

        Fbaa.ListCreatureRequest request = Fbaa.ListCreatureRequest.newBuilder()
                .setAvailable(true)
                .addRarity(rarity)
                .build();

        Iterator<Fbaa.CreatureResponse> it = fbaaBlockingStub.listCreatures(request);

        List<Fbaa.CreatureResponse> list = new ArrayList<>();
        while (it.hasNext()) {
            Fbaa.CreatureResponse creatureResponse = it.next();
            log.info("Found creature [{}]", creatureResponse.getName());
            list.add(creatureResponse);
        }

        if (list.isEmpty()) {
            return null;
        }

        Fbaa.CreatureResponse creatureResponse = list.get(random.nextInt(list.size()));
        log.info("Random creature chosen [{}]", creatureResponse.getName());

        return creatureResponse;
    }

    private void branchReserveCreature(String branch, Fbaa.CreatureResponse creatureResponse) {

        Fbaa.ReserveCreatureRequest request = Fbaa.ReserveCreatureRequest.newBuilder()
                .setBranchId(branch)
                .setId(creatureResponse.getId())
                .build();

        Empty empty = fbaaBlockingStub.reserveCreature(request);
    }
}
