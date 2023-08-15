if (-not (docker network ls -q -f "name=fbaa-network")) {
    docker network create fbaa-network
}

docker run -p 8080:80 --rm fbaa-server
