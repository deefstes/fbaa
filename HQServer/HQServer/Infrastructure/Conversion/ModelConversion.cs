using GrpcService.Core.Models;

namespace GrpcService.Infrastructure.Conversion
{
    public static class ModelConversion
    {
        public static Creature ToGrpcModel(CreatureDbModel dbModel)
        {
            var c = new Creature
            {
                Id = dbModel.Id,
                Name = dbModel.Name,
                Rarity = (Rarity)dbModel.Rarity,
                Species = dbModel.Species,
                Description = dbModel.Description,
                Available = dbModel.Available
            };
            if (dbModel.Abilities != null)
            {
                foreach (var ability in dbModel.Abilities)
                {
                    c.Abilities.Add((SpecialAbility)ability);
                }
            }
            if (dbModel.Attributes != null)
            {
                foreach (var attr in dbModel.Attributes)
                {
                    c.Attributes.Add(attr.Key, attr.Value);
                }
            }

            return c;
        }

        public static CreatureDbModel ToDbModel(Creature grpcModel)
        {
            var c = new CreatureDbModel
            {
                Id = grpcModel.Id,
                Name = grpcModel.Name,
                Rarity = (Core.Models.Rarity)grpcModel.Rarity,
                Species = grpcModel.Species,
                Description = grpcModel.Description,
                Available = grpcModel.Available,
                Abilities = new List<Core.Models.SpecialAbility>(),
                Attributes = new Dictionary<string, string>()
            };
            if (grpcModel.Abilities != null)
            {
                foreach (var ability in grpcModel.Abilities)
                {
                    c.Abilities.Add((Core.Models.SpecialAbility)ability);
                }
            }
            if (grpcModel.Attributes != null)
            {
                foreach (var attr in grpcModel.Attributes)
                {
                    c.Attributes.Add(attr.Key, attr.Value);
                }
            }

            return c;
        }
    }
}
