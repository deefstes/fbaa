using GrpcService.Core.Models;

namespace GrpcService.Core.Interfaces
{
    public interface IFantasticBeastRepository
    {
        RepoResponse AddCreature(CreatureDbModel creature);
        CreatureDbModel GetCreatureById(string id);
        List<CreatureDbModel> ListCreatures();
        RepoResponse ReserveCreature(string id);
    }

    public enum RepoResponse
    {
        Success,
        NotFound,
        NotAvailable,
        Duplicate
    }
}
