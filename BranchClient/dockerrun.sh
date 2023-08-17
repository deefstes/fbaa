#! /bin/bash

if [[ ! $(docker network ls -q -f name=fbaa-network) ]]; then
    docker network create fbaa-network
fi

docker run --network fbaa-network -p 8081:8080 --name branch-client --rm branch-client
