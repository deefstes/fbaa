using System.Text.Json;
using System.Text.Json.Serialization;

namespace GrpcService.Core.Models
{
    public class Creature
    {
        public string Id { get; set; } = null!;
        public DateTime DateAdded { get; set; }
        public string Name { get; set; } = null!;
        public Rarity Rarity { get; set; }
        public string Species { get; set; } = null!;
        public string Description { get; set; } = null!;
        public int Age { get; set; } = 0;
        public List<SpecialAbility> Abilities { get; set; } = new List<SpecialAbility>();
        public Dictionary<string, string> Attributes { get; set; } = new Dictionary<string, string>();
        public bool Available { get; set; } = false;
        public string BranchId { get; set; } = null!;

        public Creature() { }

        public Creature(string json)
        {
            var creature = JsonSerializer.Deserialize<Creature>(json, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                WriteIndented = true,
            });

            Id = creature!.Id;
            DateAdded = DateTime.UtcNow;
            Name = creature.Name;
            Rarity = creature.Rarity;
            Species = creature.Species;
            Description = creature.Description;
            Age = creature.Age;
            Abilities = creature.Abilities;
            Attributes = creature.Attributes;
            Available = creature.Available;
        }

        public string Json()
        {
            return JsonSerializer.Serialize(this, new JsonSerializerOptions
            {
                WriteIndented = true
            });
        }
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
