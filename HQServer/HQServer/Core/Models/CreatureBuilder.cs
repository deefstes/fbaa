namespace GrpcService.Core.Models
{
    public class CreatureBuilder
    {
        private Creature creature;

        public CreatureBuilder()
        {
            creature = new Creature();
            creature.Id = Guid.NewGuid().ToString();
            creature.DateAdded = DateTime.UtcNow;
            creature.Available = true;
        }

        public Creature Build()
        {
            return creature;
        }

        public CreatureBuilder WithSpecificId(string id)
        {
            creature.Id = id;
            return this;
        }

        public CreatureBuilder WithDateAdded(DateTime dt)
        {
            return this;
        }

        public CreatureBuilder WithName(string name)
        {
            creature.Name = name;
            return this;
        }

        public CreatureBuilder WithRarity(Rarity rarity)
        {
            creature.Rarity = rarity;
            return this;
        }

        public CreatureBuilder WithSpecies(string species)
        {
            creature.Species = species;
            return this;
        }

        public CreatureBuilder WithDescription(string description)
        {
            creature.Description = description;
            return this;
        }

        public CreatureBuilder WithAge(int age)
        {
            creature.Age = age;
            return this;
        }

        public CreatureBuilder WithAbility(SpecialAbility ability)
        {
            creature.Abilities.Add(ability);
            return this;
        }

        public CreatureBuilder WithAttribute(string key, string val)
        {
            creature.Attributes[key] = val;
            return this;
        }

        public CreatureBuilder Unavailable()
        {
            creature.Available = false;
            return this;
        }

        public CreatureBuilder WithBranchId(string id)
        {
            creature.BranchId = id;
            return this;
        }
    }
}
