if (-not (docker network ls -q -f "name=fbaa-network")) {
    docker network create fbaa-network
}

docker run -p 8081:8080 --rm branch-client
