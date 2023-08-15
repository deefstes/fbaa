# Fantastic Beasts Adoption Agency

## Table of contents

-   [Summary](#summary)
-   [Prerequisites](#prerequisites)
-   [API Contract (proto file)](#api-contract-proto-file)
-   [Services](#services)
    -   [HQ Server (.Net)](#hq-server-net)
    -   [Branch Client (Java)](#branch-client-java)
    -   [Discovery Service (Go)](#discovery-service-go)
-   [Running the services](#running-the-services)
    -   [HQ Server](#hq-server)
    -   [Branch Client](#branch-client)
    -   [Discovery Service](#discovery-service)
-   [Postman](#postman)

## Summary

The "Fantastic Beasts Adoption Agency" encompasses a suite of interconnected services that utilize Protocol Buffers and the gRPC protocol for the API between them. These services collectively serve as the practical illustration for a gRPC-focused presentation.

The underlying concept of the "Fantastic Beasts Adoption Agency" revolves around a central hub housing a gRPC server. This central hub acts as the headquarters responsible for overseeing the care of discovered Fantastic Beasts from the wild. Detailed information regarding these creatures is stored and managed within the central hub.

Distinct branches of the "Fantastic Beasts Adoption Agency" can interact with the central hub's server to retrieve comprehensive information about available Fantastic Beasts. Additionally, these branches can reserve specific beasts, ensuring their transfer to the respective branch for further care or placement with a custodian wizard.

In addition to the head office and branch services, a "Discovery" service serves to actively locate untamed beasts in the wilderness and populate the central hub's service with comprehensive data regarding these newfound creatures.

This collection of services seek to demonstrate how a variety of services, all utilising the same API can be written in any collection of languages with stub code generated from the single source Protocol Buffer file which acts as the service definition.

## Prerequisites

The minimum requirements for running the services is having a Docker host installed on your system. Each service has a Dockerfile which can be built and run on your Docker host.

In order to compile these services you would need to have the different SDKs installed for their respective programming languages.

If you were to make changes to the .proto file and need to generate the boilerplate code for the various services, you will need to have the [protoc compiler](https://grpc.io/docs/protoc-installation/) installed. For some languages, such as .NET core and Java Springboot, this compiler is built into the framework tooling but for some others, like Go, you will need to install the compiler and generate the stubs manually.

## API Contract (proto file)

The API contract, or the Service Definition, is defined in the [/Proto/fbaa.proto](/Proto/fbaa.proto) Protocol Buffer file. It is located in a folder off the root of the repo so that all services can use the same proto file to generate their respective stub code for implementing the API.

## Services

### HQ Server (.Net)

The [HQ Server](/HQServer/) is written in [.Net 6.0](https://dotnet.microsoft.com/en-us/) and implemented as an ASP.NET Core Web API.

The .NET solution is in the [/HQServer](/HQServer/) directory and the project in the [/HQServer/HQServer](/HQServer/HQServer) directory.

The code is organised in a rudimentary [Clean Architecture](https://medium.com/dotnet-hub/clean-architecture-with-dotnet-and-dotnet-core-aspnetcore-overview-introduction-getting-started-ec922e53bb97) configuration with layers for:

-   Core (Domain)
-   Application
-   Infrastructure

The HQ Server implements a gRPC listener according to the API defined in the [fbaa.proto](/Proto/fbaa.proto). It has no real persistence layer other than an in memory data structure (Dictionary).

### Branch Client (Java)

--- INCOMPLETE ---

### Discovery Service (Go)

The [Discovery Service](/DiscoveryService/) is written in [Go](https://go.dev/).

The code is organised in, what is known as the [Standard Go Project Layout](https://github.com/golang-standards/project-layout).

The Discovery Service simulates the "discovery" of a new Fantastic Beast every minute. Creatures are created with random names, species, descriptions, ages, abilities and rarity, which are then handed to the HQ Server.

## Running the services

Each service has a `Dockerfile` which enables building the service into a Docker image which can then be run in your local Docker host environment. There are also helper scripts for both `bash` and `PowerShell` to build the Docker images and run the containers.

### HQ Server

There is a [Dockerfile](/HQServer/HQServer/Dockerfile) in the project directory. The same directory also contains two helper scripts for building the Docker image:

-   bash: [dockerbuild.sh](/HQServer/HQServer/dockerbuild.sh)
-   PowerShell: [dockerbuild.ps1](/HQServer/HQServer/dockerbuild.ps1)

And once the image has been built, there are helper scripts for running the container:

-   bash: [dockerrun.sh](/HQServer/HQServer/dockerrun.sh)
-   PowerShell: [dockerrun.ps1](/HQServer/HQServer/dockerrun.ps1)

### Branch Client

--- INCOMPLETE ---

### Discovery Service

There is a [Dockerfile](DiscoveryService/Dockerfile) in the project directory. The same directory also contains two helper scripts for building the Docker image:

-   bash: [dockerbuild.sh](/DiscoveryService/dockerbuild.sh)
-   PowerShell: [dockerbuild.ps1](/DiscoveryService/dockerbuild.ps1)

And once the image has been built, there are helper scripts for running the container:

-   bash: [dockerrun.sh](/DiscoveryService/dockerrun.sh)
-   PowerShell: [dockerrun.ps1](/DiscoveryService/dockerrun.ps1)

## Postman

Postman provides functionality for testing gRPC APIs but, unfortunately does not allow exporting collections of gRPC requests. Below follows an explanation of how to set up a gRPC collection in Postman.

Start by creating a new blank workspace: `Workspaces -> Create Workspace -> Next`.

Provide a name for the workspace and click on `Create`

Because gRPC relies on a strict contract, we need to provide an API definition to the workspace (luckily we have a `.proto` file which is exactly that).

First ensure that the APIs option is available in the workspace sidebar. By default it won't be. To add it, click on the `Configure workspace sidebar` option...

![Sidebar](/ReadMeAssets/Sidebar.png)

Make sure the `APIs` element is selected...

![Configure Sidebar](/ReadMeAssets/ConfigureSidebar.png)

Now click on the `APIs` option in the sidebar and click on `Create an API`

![Create API](/ReadMeAssets/CreateAPI.png)

Provide a name for the API ("FBAA" is as good a name as any). Expand the newly created API (this might not be immediately obvious) and click on `Import`

![Import definition](/ReadMeAssets/Import.png)

Browse to the [fbaa.proto](/Proto/fbaa.proto) file or drag and drop it into the import dialog.

At this point your workspace will have an API with a definition. You can close any open tabs now. If you are familiar with Postman you might be tempted to get started by creating a `Collection` in which your `Requests` will be grouped. Resist this urge. Postman is buggy in this sense, or at the least rather counterintuitive. If you create a `Collection` all `Requests` in the collection wil only be able to be of the `HTTP` type.

If you've closed all open tabs, you should see the watermarked Postman logo in the middle of your screen with some options below to create new requests. Click on the `gRPC` icon to create a new gRPC request.

![Create request](/ReadMeAssets/CreateRequest.png)

In the URL field, add the location of the HQServer listener. If you used one of the helper scripts in the repo to start the service (see [Running the services](#running-the-services)), the correct address to enter here is `grpc://localhost:8080`

Click on the `Select a method` text box. It will expand and allow you to add a service definition. Under `Use a Protobuf API` select the `FBAA` service definition that was just created.

![Add service definition](/ReadMeAssets/SearchAPI.png)

The available RPC methods from this API will now be displayed. Click on the `ListCreatures` method.

![ListCreatures](/ReadMeAssets/ListCreatures.png)

In the message body add the following message:

```json
{
	"available": true,
	"rarity": ["RARE", "LEGENDARY"],
	"ability": ["FLYING"]
}
```

This will list all available creatures of which the rarity is either `RARE` or `LEGENDARY` and that has the ability of `FLYING`.

Click `Invoke` and see ther returned responses. This is a streaming endpoint so you could get multiple responses, one after the other.

You can play around with the filter message above. Try different `rarity` or `ability` values or leave some fields out entirely.

At this point you can save the request into a collection by clicking on the `Save` buton in the top right.

Creating the collection and creating requests for the other three RPC methods is left as an exercise for the reader.
