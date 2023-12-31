#! /bin/bash

if [[ ! $(docker network ls -q -f name=fbaa-network) ]]; then
    docker network create fbaa-network
fi

docker run --network fbaa-network -e FBAA_ADDRESS=fbaa-server -e FBAA_PORT=80 -e FBAA_INTERVAL=60 --name fbaa-discovery --rm fbaa-discovery
