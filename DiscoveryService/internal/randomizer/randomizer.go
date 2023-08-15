package randomizer

import (
	"fbaa/models"
	"fmt"
	"math/rand"
)

type Randomizer struct {
	namePrefix     []string
	namePostfix    []string
	speciesPrefix  []string
	speciesPostfix []string
}

func NewRandomizer() Randomizer {
	return Randomizer{
		namePrefix: []string{
			"Buck",
			"Snap",
			"Chunk",
			"Snot",
			"Ridge",
			"Stripe",
			"Electro",
			"Magno",
			"Plani",
			"Omni",
			"Rich",
			"Crooked",
			"Schloofy",
			"Quirk",
			"Fizz",
			"Wobble",
			"Glimmer",
			"Bumble",
			"Snicker",
			"Jumble",
			"Munch",
			"Doodle",
			"Baffle",
			"Noodle",
			"Flutter",
			"Wiggle",
			"Squiggle",
			"Plop",
		},
		namePostfix: []string{
			"beak",
			"bill",
			"claw",
			"foot",
			"tail",
			"pelt",
			"mane",
			"tooth",
			"back",
			"rump",
			"skin",
			"fur",
			"neck",
			"belly",
			"whisker",
			"toes",
			"splat",
			"noodle",
			"bop",
			"paws",
			"wiggle",
			"snout",
			"jiggle",
			"blink",
			"munch",
			"giggle",
			"tumble",
			"bounce",
		},
		speciesPrefix: []string{
			"Hippo",
			"Gi",
			"Ele",
			"Croco",
			"Bumble",
			"Ante",
			"Rein",
			"Ze",
			"Leo",
			"Buffa",
			"Moni",
			"Liz",
			"Chame",
			"Taran",
			"Scor",
			"Centi",
			"Kanga",
			"Honey",
			"Ana",
			"Centi",
			"Butter",
			"Cater",
			"Rhino",
			"Wart",
			"Spring",
			"Oce",
			"Capy",
			"Coli",
		},
		speciesPostfix: []string{
			"potamus",
			"raffe",
			"phant",
			"dile",
			"bee",
			"lope",
			"deer",
			"bra",
			"pard",
			"lo",
			"tor",
			"zard",
			"leon",
			"tula",
			"pion",
			"pede",
			"roo",
			"badger",
			"conda",
			"taur",
			"fly",
			"pillar",
			"ceros",
			"hog",
			"bok",
			"lot",
			"bara",
			"bri",
		},
	}
}

func (c *Randomizer) randomRarity() models.Rarity {
	return models.Rarity(rand.Intn(int(models.Rarity_LEGENDARY) + 1))
}

func (c *Randomizer) randomAbility() models.SpecialAbility {
	return models.SpecialAbility(rand.Intn(int(models.SpecialAbility_REGENERATION) + 1))
}

func (c *Randomizer) randomName() string {
	return fmt.Sprintf("%s%s", c.namePrefix[rand.Intn(len(c.namePrefix))], c.namePostfix[rand.Intn(len(c.namePostfix))])
}

func (c *Randomizer) randomSpecies() string {
	return fmt.Sprintf("%s%s", c.speciesPrefix[rand.Intn(len(c.speciesPrefix))], c.speciesPostfix[rand.Intn(len(c.speciesPostfix))])
}

func (c *Randomizer) RandomCreature() models.Creature {
	creature := models.Creature{
		Name:      c.randomName(),
		Species:   c.randomSpecies(),
		Rarity:    c.randomRarity(),
		Available: true,
	}

	for i := 0; i < rand.Intn(2)+1; i++ {
		creature.Abilities = append(creature.Abilities, c.randomAbility())
	}

	return creature
}
