using System.Text.Json;
using System.Text.Json.Serialization;

namespace GrpcService.Core.Models
{
    public class CreatureDbModel
    {
        public CreatureDbModel() { }

        public CreatureDbModel(string json)
        {
            var creature = JsonSerializer.Deserialize<CreatureDbModel>(json, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                WriteIndented = true,
            });

            Id = creature.Id;
            Name = creature.Name;
            Rarity = creature.Rarity;
            Species = creature.Species;
            Description = creature.Description;
            Abilities = creature.Abilities;
            Available = creature.Available;
            Attributes = creature.Attributes;
        }

        public string Json()
        {
            return JsonSerializer.Serialize(this, new JsonSerializerOptions
            {
                WriteIndented = true
            });
        }

        public string Id { get; set; }
        public string Name { get; set; }
        public Rarity Rarity { get; set; }
        public string Species { get; set; }
        public string Description { get; set; }
        public List<SpecialAbility> Abilities { get; set; }
        public bool Available { get; set; }
        public Dictionary<string, string> Attributes { get; set; }
    }

    [JsonConverter(typeof(JsonStringEnumConverter))]
    public enum Rarity
    {
        Common = 0,
        Uncommon = 1,
        Rare = 2,
        Legendary = 3,
    }

    [JsonConverter(typeof(JsonStringEnumConverter))]
    public enum SpecialAbility
    {
        Flying = 0,
        Teleportation = 1,
        Invisibility = 2,
        Shapeshifting = 3,
        FireBreathing = 4,
        Telepathy = 5,
        IceMagic = 6,
        ElectricDischarge = 7,
        Regeneration = 8,
    }
}
