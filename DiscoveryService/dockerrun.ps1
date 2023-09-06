if (-not (docker network ls -q -f "name=fbaa-network")) {
    docker network create fbaa-network
}

docker run -e FBAA_ADDRESS=localhost -e FBAA_PORT=80 -e FBAA_INTERVAL=60 --rm fbaa-discovery
