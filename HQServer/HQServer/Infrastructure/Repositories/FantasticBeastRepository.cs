using GrpcService.Core.Interfaces;
using GrpcService.Core.Models;

namespace GrpcService.Infrastructure.Repositories
{
    public class FantasticBeastRepository : IFantasticBeastRepository
    {
        private readonly Dictionary<string, Creature> _creatures;
        public FantasticBeastRepository()
        {
            _creatures = SeedRepository();
        }

		public RepoResponse AddCreature(Creature creature)
		{
			if (_creatures.ContainsKey(creature.Id))
				return RepoResponse.Duplicate;

			_creatures[creature.Id] = creature;
			return RepoResponse.Success;
		}

        public Creature GetCreatureById(string id)
        {
            if (_creatures.ContainsKey(id))
            {
                return _creatures[id];
            }
            else
            {
                return null;
            }
        }

		public List<Creature> GetCreatures()
		{
            var response = new List<Creature>();
			foreach (var creature in _creatures.Values)
			{
				response.Add(creature);
			}

			return response;
		}

        public RepoResponse ReserveCreature(string id, string branchId)
		{
			if (!_creatures.ContainsKey(id))
				return RepoResponse.NotFound;

			if (!_creatures[id].Available)
				return RepoResponse.NotAvailable;

			_creatures[id].Available = false;
			_creatures[id].BranchId = branchId;

			return RepoResponse.Success;
		}

        private Dictionary<string, Creature> SeedRepository()
        {
            var creatures = new Dictionary<string, Creature>();

			Action<Creature> addCreature = (Creature creature) => {
				creatures[creature.Id] = creature;
			};

            //return creatures;

            addCreature(new CreatureBuilder()
                .WithSpecificId("b6f1f876-8e2f-4c59-a65c-68d1db9e1d54")
                .WithName("Mystic Griffin")
                .WithRarity(Core.Models.Rarity.Legendary)
                .WithSpecies("Griffin")
                .WithDescription("A majestic creature with the body of a lion and the head and wings of an eagle.")
                .WithAge(128)
                .WithAbility(Core.Models.SpecialAbility.Flying)
                .WithAbility(Core.Models.SpecialAbility.Telepathy)
                .WithAttribute("Strength", "Incredible agility and aerial combat skills.")
                .WithAttribute("Weakness", "Susceptible to powerful magical spells.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("a8b2e437-2a62-4a86-ae88-9187818f4ae0")
                .WithName("Enchanted Phoenix")
                .WithRarity(Core.Models.Rarity.Legendary)
                .WithSpecies("Phoenix")
                .WithDescription("A majestic bird that bursts into flames upon death and is reborn from its ashes.")
                .WithAge(1482)
                .WithAbility(Core.Models.SpecialAbility.FireBreathing)
                .WithAbility(Core.Models.SpecialAbility.Regeneration)
                .WithAttribute("Strength", "Immunity to fire and exceptional healing Abilities.")
                .WithAttribute("Weakness", "Susceptible to water-based attacks.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("c5d7e98f-746b-45d8-8a3c-90c9f8e47c33")
                .WithName("Spectral Serpent")
                .WithRarity(Core.Models.Rarity.Rare)
                .WithSpecies("Serpent")
                .WithDescription("An ethereal serpent that glIdes through shadows and phases through solId objects.")
                .WithAge(325)
                .WithAbility(Core.Models.SpecialAbility.Invisibility)
                .WithAbility(Core.Models.SpecialAbility.Shapeshifting)
                .WithAttribute("Aspect", "Can manipulate shadows to create illusions and confusion.")
                .WithAttribute("Habitat", "Prefers dark and concealed environments.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("f3a7b8c9-5e24-42a1-9bd6-6a8f97b03d20")
                .WithName("Cursed Gargoyle")
                .WithRarity(Core.Models.Rarity.Uncommon)
                .WithSpecies("Gargoyle")
                .WithDescription("A stone creature brought to life by ancient curses, guarding secrets and treasures.")
                .WithAge(7100)
                .WithAbility(Core.Models.SpecialAbility.Flying)
                .WithAbility(Core.Models.SpecialAbility.Teleportation)
                .Unavailable()
                .WithAttribute("Guardian", "Protects hIdden treasures and cursed artifacts.")
                .WithAttribute("Curse", "Transforms into stone during daylight hours.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("d2e0f9c4-1b6a-497c-9f8d-3e4a5b6c2d1e")
                .WithName("Mistral Unicorn")
                .WithRarity(Core.Models.Rarity.Common)
                .WithSpecies("Unicorn")
                .WithDescription("A gentle creature with a spiral horn and the power to manipulate wind and weather.")
                .WithAge(12)
                .WithAbility(Core.Models.SpecialAbility.Flying)
                .WithAbility(Core.Models.SpecialAbility.Telepathy)
                .WithAttribute("Nature Affinity", "Harmony with natural elements and affinity for serene environments.")
                .WithAttribute("Gentle Spirit", "Known to calm storms and offer protection to those in need.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("9a8b7c6d-5e3f-48a2-9c1d-2b3e4f5a6d7c")
                .WithName("Celestial Sphinx")
                .WithRarity(Core.Models.Rarity.Rare)
                .WithSpecies("Sphinx")
                .WithDescription("A wise and enigmatic creature with the body of a lion and the wings of an eagle.")
                .WithAge(4000)
                .WithAbility(Core.Models.SpecialAbility.Telepathy)
                .WithAttribute("Riddles", "Known for posing complex riddles and granting wisdom to those who solve them.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("4e5d6c7b-2a1f-4d3c-9e8b-7f6a5d4e3c2")
                .WithName("Aurora Dragon")
                .WithRarity(Core.Models.Rarity.Legendary)
                .WithSpecies("Dragon")
                .WithDescription("A colossal dragon that breathes colorful flames and dances through the night sky.")
                .WithAge(719)
                .WithAbility(Core.Models.SpecialAbility.Flying)
                .WithAbility(Core.Models.SpecialAbility.FireBreathing)
                .WithAbility(Core.Models.SpecialAbility.Shapeshifting)
                .WithAttribute("Aurora Flames", "Breathes flames that create mesmerizing auroras in the sky.")
                .WithAttribute("Shapeshifter", "Can transform into various forms to adapt to different environments.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("1f2e3d4c-9b8a-5e6d-7c4b-3a2f1e9d8c7")
                .WithName("Aquatic Nymph")
                .WithRarity(Core.Models.Rarity.Uncommon)
                .WithSpecies("Nymph")
                .WithDescription("An ethereal water spirit with the ability to control and protect aquatic ecosystems.")
                .WithAge(69)
                .WithAbility(Core.Models.SpecialAbility.IceMagic)
                .WithAbility(Core.Models.SpecialAbility.Teleportation)
                .WithAttribute("Protector of Waters", "Ensures balance and harmony in underwater ecosystems.")
                .WithAttribute("Aquatic Affinity", "Has a deep connection to lakes, rivers, and oceans.")
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("7e6d5c4b-1f9a-2e8d-3c7b-4a5f6e9d8c")
                .WithName("Ember Sprite")
                .WithRarity(Core.Models.Rarity.Common)
                .WithSpecies("Sprite")
                .WithDescription("A mischievous sprite that leaves behind trails of glowing embers as it dashes about.")
                .WithAge(3)
                .WithAbility(Core.Models.SpecialAbility.IceMagic)
                .Build());

            addCreature(new CreatureBuilder()
                .WithSpecificId("8d9c7b5a-6e4d-3f1a-2b8c-9e7d5c6b4a")
                .WithName("Lunar Owl")
                .WithRarity(Core.Models.Rarity.Uncommon)
                .WithSpecies("Owl")
                .WithDescription("An owl that glows with the soft light of the moon and is associated with night wisdom.")
                .WithAge(5)
                .WithAbility(Core.Models.SpecialAbility.Flying)
                .WithAbility(Core.Models.SpecialAbility.Telepathy)
                .WithAttribute("Messenger of Dreams", "Conveys messages and insights through dreams.")
                .Build());

            return creatures;
        }
    }
}
