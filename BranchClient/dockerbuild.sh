#! /bin/bash

cp ../Proto/fbaa.proto .
docker build -t branch-client  .
rm fbaa.proto