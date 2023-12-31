using Google.Protobuf.WellKnownTypes;
using Grpc.Core;
using GrpcService.Core.Interfaces;
using GrpcService.Infrastructure.Conversion;

namespace GrpcService.Application.Services
{
    public class FBAAService : FBAA.FBAABase
    {
        private readonly ILogger<FBAAService> _logger;
        private readonly IFantasticBeastRepository _beastRepository;
        public FBAAService(ILogger<FBAAService> logger, IFantasticBeastRepository beastRepository)
        {
            _logger = logger;
            _beastRepository = beastRepository;
        }

        public override Task<Empty> AddCreature(AddCreatureRequest request, ServerCallContext context)
        {
            switch (_beastRepository.AddCreature(ModelConversion.ToDbModel(request)))
            {
                case RepoResponse.Success:
                    return Task.FromResult(new Empty());
                case RepoResponse.Duplicate:
                    throw new RpcException(new Status(StatusCode.AlreadyExists, "Error adding creature to database"));
                default:
                    throw new RpcException(new Status(StatusCode.Unknown, "Error adding creature to database"));
            }
        }

        public override Task<CreatureResponse> GetCreature(GetCreatureRequest request, ServerCallContext context)
        {
            var creature = _beastRepository.GetCreatureById(request.Id);
            if (creature != null)
            {
                return Task.FromResult(ModelConversion.ToGrpcModel(creature));
            }
            else
            {
                throw new RpcException(new Status(StatusCode.NotFound, "Creature not found"));
            }
        }

        public override async Task StreamCreatures(StreamCreatureRequest request, IServerStreamWriter<CreatureResponse> responseStream, ServerCallContext context)
        {

            foreach (var creature in _beastRepository.GetCreatures())
            {
                bool matchesRarity = request.Rarity.Any() ? false : true;
                foreach(var rarity in request.Rarity)
                {
                    if (creature.Rarity == (Core.Models.Rarity)rarity)
                        matchesRarity = true;
                }

                bool matchesAbilities = request.Ability.Any()
                    ? request.Ability.All(ability => creature.Abilities.Contains((Core.Models.SpecialAbility)ability))
                    : true;

                bool matchesAvailability = request.Available == creature.Available;

                bool matchesBranch = request.BranchId == "";
                if (!matchesBranch)
                    matchesBranch = request.BranchId == (creature.BranchId??"");

                if (matchesRarity && matchesAbilities && matchesAvailability && matchesBranch)
                    await responseStream.WriteAsync(ModelConversion.ToGrpcModel(creature));
            }
        }

        public override Task<Empty> ReserveCreature(ReserveCreatureRequest request, ServerCallContext context)
        {
            switch (_beastRepository.ReserveCreature(request.Id, request.BranchId))
            {
                case RepoResponse.Success:
                    return Task.FromResult(new Empty());
                case RepoResponse.NotFound:
                    throw new RpcException(new Status(StatusCode.NotFound, "Creature not found in database"));
                case RepoResponse.NotAvailable:
                    throw new RpcException(new Status(StatusCode.FailedPrecondition, "Creature not available"));
                default:
                    throw new RpcException(new Status(StatusCode.Unknown, "Error reserving creature"));
            }
        }
    }
}