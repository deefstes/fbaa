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
	adverba        []string
	adverbb        []string
	adjective      []string
	tendency       []string
	verb           []string
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
		adverba: []string{
			"An exceptionally",
			"An incredibly",
			"A terribly",
			"A remarkably",
			"An unbelievably",
			"An insanely",
			"An awfully",
			"A quite",
			"A truly",
			"A rather",
			"An exceedingly",
			"An immensely",
			"An extremely",
			"An intensely",
			"An unusually",
			"A moderately",
			"A very",
			"A minimally",
			"A nearly",
			"A totally",
		},
		adverbb: []string{
			"loudly",
			"noisily",
			"quietly",
			"stealthily",
			"briskly",
			"carefully",
			"efficiently",
			"gracefully",
			"hastily",
			"intently",
			"lazily",
			"quickly",
			"rapidly",
			"slowly",
			"steadily",
			"swiftly",
			"thoroughly",
			"vigorously",
			"wisely",
			"deliberately",
			"firmly",
			"gently",
			"harshly",
			"patiently",
		},
		adjective: []string{
			"beautiful",
			"strong",
			"clever",
			"bright",
			"gentle",
			"creative",
			"joyful",
			"mysterious",
			"energetic",
			"sincere",
			"enthusiastic",
			"reliable",
			"delicious",
			"peaceful",
			"playful",
			"ancient",
			"confident",
			"cautious",
			"grateful",
			"curious",
		},
		tendency: []string{
			"a disposition to",
			"a propensity for",
			"a habit of",
			"an affinity for",
			"an inclination to",
			"a bent of",
			"an orientation of",
			"an instinct of",
			"a predisposition to",
			"a penchant to",
			"a tendency of",
			"a preference for",
			"a liking of",
			"a predilection for",
			"a partiality to",
			"a proclivity to",
			"a passion for",
			"an aptitude for",
			"a taste for",
			"a prejudice for",
		},
		verb: []string{
			"running",
			"singing",
			"reading",
			"dancing",
			"writing",
			"cooking",
			"laughing",
			"swimming",
			"talking",
			"sleeping",
			"playing",
			"painting",
			"eating",
			"watching",
			"studying",
			"eating",
			"working",
			"listening",
			"jumping",
			"munching",
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
	return fmt.Sprintf("%s%s", pickRandomItem(c.namePrefix), pickRandomItem(c.namePostfix))
}

func (c *Randomizer) randomSpecies() string {
	return fmt.Sprintf("%s%s", pickRandomItem(c.speciesPrefix), pickRandomItem(c.speciesPostfix))
}

func (c *Randomizer) randomDescription() string {
	return fmt.Sprintf(
		"%s %s creature that has %s %s %s.",
		pickRandomItem(c.adverba),
		pickRandomItem(c.adjective),
		pickRandomItem(c.tendency),
		pickRandomItem(c.verb),
		pickRandomItem(c.adverbb),
	)
}

func (c *Randomizer) randomAge() int32 {
	return int32(rand.Intn(10000) + 1)
}

func (c *Randomizer) RandomCreature() models.Creature {
	creature := models.Creature{
		Name:        c.randomName(),
		Species:     c.randomSpecies(),
		Rarity:      c.randomRarity(),
		Description: c.randomDescription(),
		Age:         c.randomAge(),
	}

	for i := 0; i < rand.Intn(2)+1; i++ {
		creature.Abilities = append(creature.Abilities, c.randomAbility())
	}

	return creature
}

func pickRandomItem(items []string) string {
	return items[rand.Intn(len(items))]
}
