using GrpcService.Core.Models;

namespace GrpcService.Core.Interfaces
{
    public interface IFantasticBeastRepository
    {
        RepoResponse AddCreature(CreatureDbModel creature);
        CreatureDbModel GetCreatureById(string id);
        List<CreatureDbModel> GetCreatures();
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
