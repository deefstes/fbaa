#! /bin/bash

protoc -I../../../Proto -I"$GOOGLE_APIS" --go_out=. --go_opt=paths=source_relative --go-grpc_out=. --go-grpc_opt=require_unimplemented_servers=false,paths=source_relative fbaa.proto
