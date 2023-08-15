package models

import "time"

type Creature struct {
	Id          string
	DateAdded   time.Time
	Name        string
	Rarity      Rarity
	Species     string
	Description string
	Age         int32
	Abilities   []SpecialAbility
	Attributes  map[string]string
	Available   bool
	BranchId    string
}

type Rarity int32

const (
	Rarity_COMMON    Rarity = 0
	Rarity_UNCOMMON  Rarity = 1
	Rarity_RARE      Rarity = 2
	Rarity_LEGENDARY Rarity = 3
)

type SpecialAbility int32

const (
	SpecialAbility_FLYING             SpecialAbility = 0
	SpecialAbility_TELEPORTATION      SpecialAbility = 1
	SpecialAbility_INVISIBILITY       SpecialAbility = 2
	SpecialAbility_SHAPESHIFTING      SpecialAbility = 3
	SpecialAbility_FIRE_BREATHING     SpecialAbility = 4
	SpecialAbility_TELEPATHY          SpecialAbility = 5
	SpecialAbility_ICE_MAGIC          SpecialAbility = 6
	SpecialAbility_ELECTRIC_DISCHARGE SpecialAbility = 7
	SpecialAbility_REGENERATION       SpecialAbility = 8
)
