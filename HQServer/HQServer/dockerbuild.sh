#! /bin/bash

cp ../../Proto/fbaa.proto ..
docker build -t fbaa-server -f Dockerfile ..
rm ../fbaa.proto