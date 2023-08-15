#See https://aka.ms/customizecontainer to learn how to customize your debug container and how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /Proto
COPY ["fbaa.proto", "."]
WORKDIR /src
COPY ["HQServer/HQServer.csproj", "HQServer/"]
RUN dotnet restore "HQServer/HQServer.csproj"
COPY . .
WORKDIR "/src/HQServer"
RUN dotnet build "HQServer.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "HQServer.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "HQServer.dll"]