using GrpcService.Core.Models;

namespace GrpcService.Core.Interfaces
{
    public interface IFantasticBeastRepository
    {
        RepoResponse AddCreature(Creature creature);
        Creature GetCreatureById(string id);
        List<Creature> GetCreatures();
        RepoResponse ReserveCreature(string id, string branchId);
    }

    public enum RepoResponse
    {
        Success,
        NotFound,
        NotAvailable,
        Duplicate
    }
}
