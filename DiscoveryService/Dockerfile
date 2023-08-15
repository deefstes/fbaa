# Build stage
FROM golang:1.20.2-alpine3.17 AS builder
LABEL dockerstage=modules
WORKDIR /app
COPY . .
RUN go mod download
RUN go build -o discoverysvc cmd/main.go

# Final stage
FROM alpine:3.17.3 AS final
WORKDIR /app
COPY --from=builder /app/discoverysvc .
CMD ./discoverysvc