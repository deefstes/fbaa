#! /bin/bash

if [[ ! $(docker network ls -q -f name=fbaa-network) ]]; then
    docker network create fbaa-network
fi

docker run --network fbaa-network -p 8080:80 --name fbaa-server --rm fbaa-server
