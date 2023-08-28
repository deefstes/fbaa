package wiz.fbaa.branchclient.branch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import wiz.fbaa.branchclient.grpc.Fbaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class BranchConfig {
    private String name;
    private int zeroToAbilities;
    private List<Fbaa.Rarity> rarity;


    private static Random random = new Random();

    // Static branches
    private static final List<BranchConfig> branch = new ArrayList<BranchConfig>(){{
        add(new BranchConfig("Hogwarts School of Witchcraft and Wizardry", 3, new ArrayList<Fbaa.Rarity>(){{
            add(Fbaa.Rarity.COMMON); add(Fbaa.Rarity.LEGENDARY);
        }}));
        add(new BranchConfig("Beauxbatons Academy of Magic", 2, new ArrayList<Fbaa.Rarity>(){{
            add(Fbaa.Rarity.UNCOMMON); add(Fbaa.Rarity.RARE);
        }}));
        add(new BranchConfig("Durmstrang Institute", 1, new ArrayList<Fbaa.Rarity>(){{
            add(Fbaa.Rarity.LEGENDARY); add(Fbaa.Rarity.RARE);
        }}));
        add(new BranchConfig("Mahoutokoro School of Magic", 3, new ArrayList<Fbaa.Rarity>(){{
            add(Fbaa.Rarity.UNCOMMON); add(Fbaa.Rarity.LEGENDARY);
        }}));
    }};

    public static BranchConfig getRandomBranch() {
        int branchInt = random.nextInt(branch.size());
        return branch.get(branchInt);
    }

    public Fbaa.Rarity getRandomRarity() {
        int rarityInt = random.nextInt(rarity.size());
        return rarity.get(rarityInt);
    }

    public List<Fbaa.SpecialAbility> getRandomAbilities() {
        // Randomly chooses a number between zero to the number abilities the branch is looking for
        int numberOfAbilities = random.nextInt(zeroToAbilities + 1);

        List<Fbaa.SpecialAbility> abilities = new ArrayList<>();
        if (numberOfAbilities == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < numberOfAbilities; i++) {
            int abilityInt = random.nextInt(Fbaa.SpecialAbility.values().length);
            abilities.add(Fbaa.SpecialAbility.forNumber(abilityInt));
        }

        return abilities;
    }
}
