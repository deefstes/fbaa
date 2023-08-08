using GrpcService.Core.Interfaces;
using GrpcService.Core.Models;

namespace GrpcService.Infrastructure.Repositories
{
    public class FantasticBeastRepository : IFantasticBeastRepository
    {
        private readonly Dictionary<string, CreatureDbModel> _creatures;
        public FantasticBeastRepository()
        {
            _creatures = SeedRepository();
        }

		public RepoResponse AddCreature(CreatureDbModel creature)
		{
			if (_creatures.ContainsKey(creature.Id))
				return RepoResponse.Duplicate;

			_creatures[creature.Id] = creature;
			return RepoResponse.Success;
		}

        public CreatureDbModel GetCreatureById(string id)
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

		public List<CreatureDbModel> ListCreatures()
		{
            var response = new List<CreatureDbModel>();
			foreach (var creature in _creatures.Values)
			{
				response.Add(creature);
			}

			return response;
		}

        public RepoResponse ReserveCreature(string id)
		{
			if (!_creatures.ContainsKey(id))
				return RepoResponse.NotFound;

			if (!_creatures[id].Available)
				return RepoResponse.NotAvailable;

			_creatures[id].Available = false;

			return RepoResponse.Success;
		}

        private Dictionary<string, CreatureDbModel> SeedRepository()
        {
            var creatures = new Dictionary<string, CreatureDbModel>();
            creatures["b6f1f876-8e2f-4c59-a65c-68d1db9e1d54"] = new CreatureDbModel(@"{
                ""Id"": ""b6f1f876-8e2f-4c59-a65c-68d1db9e1d54"",
                ""Name"": ""Mystic Griffin"",
                ""Rarity"": ""Legendary"",
                ""Species"": ""Griffin"",
                ""Description"": ""A majestic creature with the body of a lion and the head and wings of an eagle."",
                ""Abilities"": [
                    ""Flying"",
                    ""Telepathy""
                ],
                ""Available"": true,
                ""Attributes"": {
                    ""Strength"": ""Incredible agility and aerial combat skills."",
                    ""Weakness"": ""Susceptible to powerful magical spells.""
                }
            }");
            creatures["a8b2e437-2a62-4a86-ae88-9187818f4ae0"] = new CreatureDbModel(@"{
				""Id"": ""a8b2e437-2a62-4a86-ae88-9187818f4ae0"",
				""Name"": ""Enchanted Phoenix"",
				""Rarity"": ""Legendary"",
				""Species"": ""Phoenix"",
				""Description"": ""A majestic bird that bursts into flames upon death and is reborn from its ashes."",
				""Abilities"": [""FireBreathing"", ""Regeneration""],
				""Available"": true,
				""Attributes"": {
					""Strength"": ""Immunity to fire and exceptional healing Abilities."",
					""Weakness"": ""Susceptible to water-based attacks.""
				}
			}");
            creatures["c5d7e98f-746b-45d8-8a3c-90c9f8e47c33"] = new CreatureDbModel(@"{
				""Id"": ""c5d7e98f-746b-45d8-8a3c-90c9f8e47c33"",
				""Name"": ""Spectral Serpent"",
				""Rarity"": ""RARE"",
				""Species"": ""Serpent"",
				""Description"": ""An ethereal serpent that glIdes through shadows and phases through solId objects."",
				""Abilities"": [""Invisibility"", ""Shapeshifting""],
				""Available"": true,
				""Attributes"": {
					""Aspect"": ""Can manipulate shadows to create illusions and confusion."",
					""Habitat"": ""Prefers dark and concealed environments.""
				}
			}");
            creatures["f3a7b8c9-5e24-42a1-9bd6-6a8f97b03d20"] = new CreatureDbModel(@"{
				""Id"": ""f3a7b8c9-5e24-42a1-9bd6-6a8f97b03d20"",
				""Name"": ""Cursed Gargoyle"",
				""Rarity"": ""UNCOMMON"",
				""Species"": ""Gargoyle"",
				""Description"": ""A stone creature brought to life by ancient curses, guarding secrets and treasures."",
				""Abilities"": [""Flying"", ""Teleportation""],
				""Available"": false,
				""Attributes"": {
					""Guardian"": ""Protects hIdden treasures and cursed artifacts."",
					""Curse"": ""Transforms into stone during daylight hours.""
				}
			}");
            creatures["d2e0f9c4-1b6a-497c-9f8d-3e4a5b6c2d1e"] = new CreatureDbModel(@"{
				""Id"": ""d2e0f9c4-1b6a-497c-9f8d-3e4a5b6c2d1e"",
				""Name"": ""Mistral Unicorn"",
				""Rarity"": ""COMMON"",
				""Species"": ""Unicorn"",
				""Description"": ""A gentle creature with a spiral horn and the power to manipulate wind and weather."",
				""Abilities"": [""Flying"", ""Telepathy""],
				""Available"": true,
				""Attributes"": {
					""Nature Affinity"": ""Harmony with natural elements and affinity for serene environments."",
					""Gentle Spirit"": ""Known to calm storms and offer protection to those in need.""
				}
			}");
            creatures["9a8b7c6d-5e3f-48a2-9c1d-2b3e4f5a6d7c"] = new CreatureDbModel(@"{
				""Id"": ""9a8b7c6d-5e3f-48a2-9c1d-2b3e4f5a6d7c"",
				""Name"": ""Celestial Sphinx"",
				""Rarity"": ""RARE"",
				""Species"": ""Sphinx"",
				""Description"": ""A wise and enigmatic creature with the body of a lion and the wings of an eagle."",
				""Abilities"": [""Telepathy""],
				""Available"": true,
				""Attributes"": {
					""RIddles"": ""Known for posing complex rIddles and granting wisdom to those who solve them.""
				}
			}");
            creatures["4e5d6c7b-2a1f-4d3c-9e8b-7f6a5d4e3c2"] = new CreatureDbModel(@"{
				""Id"": ""4e5d6c7b-2a1f-4d3c-9e8b-7f6a5d4e3c2"",
				""Name"": ""Aurora Dragon"",
				""Rarity"": ""LEGENDARY"",
				""Species"": ""Dragon"",
				""Description"": ""A colossal dragon that breathes colorful flames and dances through the night sky."",
				""Abilities"": [""Flying"", ""FireBreathing"", ""Shapeshifting""],
				""Available"": true,
				""Attributes"": {
					""Aurora Flames"": ""Breathes flames that create mesmerizing auroras in the sky."",
					""Shapeshifter"": ""Can transform into various forms to adapt to different environments.""
				}
			}");
            creatures["1f2e3d4c-9b8a-5e6d-7c4b-3a2f1e9d8c7"] = new CreatureDbModel(@"{
				""Id"": ""1f2e3d4c-9b8a-5e6d-7c4b-3a2f1e9d8c7"",
				""Name"": ""Aquatic Nymph"",
				""Rarity"": ""UNCOMMON"",
				""Species"": ""Nymph"",
				""Description"": ""An ethereal water spirit with the ability to control and protect aquatic ecosystems."",
				""Abilities"": [""IceMagic"", ""Teleportation""],
				""Available"": true,
				""Attributes"": {
					""Protector of Waters"": ""Ensures balance and harmony in underwater ecosystems."",
					""Aquatic Affinity"": ""Has a deep connection to lakes, rivers, and oceans.""
				}
			}");
            creatures["7e6d5c4b-1f9a-2e8d-3c7b-4a5f6e9d8c"] = new CreatureDbModel(@"{
				""Id"": ""7e6d5c4b-1f9a-2e8d-3c7b-4a5f6e9d8c"",
				""Name"": ""Ember Sprite"",
				""Rarity"": ""COMMON"",
				""Species"": ""Sprite"",
				""Description"": ""A mischievous sprite that leaves behind trails of glowing embers as it dashes about."",
				""Abilities"": [""IceMagic""],
				""Available"": true
			}");
            creatures["8d9c7b5a-6e4d-3f1a-2b8c-9e7d5c6b4a"] = new CreatureDbModel(@"{
				""Id"": ""8d9c7b5a-6e4d-3f1a-2b8c-9e7d5c6b4a"",
				""Name"": ""Lunar Owl"",
				""Rarity"": ""UNCOMMON"",
				""Species"": ""Owl"",
				""Description"": ""An owl that glows with the soft light of the moon and is associated with night wisdom."",
				""Abilities"": [""Flying"", ""Telepathy""],
				""Available"": true,
				""Attributes"": {
				""Messenger of Dreams"": ""Conveys messages and insights through dreams.""
				}
			}");

            return creatures;
        }
    }
}
