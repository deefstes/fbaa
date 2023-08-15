using GrpcService.Core.Models;
using Google.Protobuf.WellKnownTypes;

namespace GrpcService.Infrastructure.Conversion
{
    public static class ModelConversion
    {
        public static CreatureResponse ToGrpcModel(CreatureDbModel dbModel)
        {
            var c = new CreatureResponse
            {
                Id = dbModel.Id,
                DateAdded = Timestamp.FromDateTime(dbModel.DateAdded),
                Name = dbModel.Name,
                Rarity = (Rarity)dbModel.Rarity,
                Species = dbModel.Species,
                Description = dbModel.Description,
                Age = dbModel.Age,
                Available = dbModel.Available,
                BranchId = dbModel.BranchId ?? "",
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

        public static CreatureDbModel ToDbModel(AddCreatureRequest grpcModel)
        {
            var c = new CreatureDbModel
            {
                Id = Guid.NewGuid().ToString(),
                DateAdded = DateTime.UtcNow,
                Name = grpcModel.Name,
                Rarity = (Core.Models.Rarity)grpcModel.Rarity,
                Species = grpcModel.Species,
                Description = grpcModel.Description,
                Age = grpcModel.Age,
                Abilities = new List<Core.Models.SpecialAbility>(),
                Attributes = new Dictionary<string, string>(),
                Available = true
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
