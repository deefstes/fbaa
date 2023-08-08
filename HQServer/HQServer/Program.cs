using GrpcService.Application.Services;
using GrpcService.Core.Interfaces;
using GrpcService.Infrastructure.Repositories;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddSingleton<IFantasticBeastRepository, FantasticBeastRepository>();
builder.Services.AddGrpc();
var app = builder.Build();
app.MapGrpcService<FBAAService>();
app.MapGet("/", () => "Communication with gRPC endpoints must be made through a gRPC client. To learn how to create a client, visit: https://go.microsoft.com/fwlink/?linkid=2086909");
app.Run();
