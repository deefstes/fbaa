package main

import (
	config "fbaa/internal/configuration"
	fbaa "fbaa/internal/grpc"
	"fbaa/internal/randomizer"
	"fmt"
	"os"
	"os/signal"
	"syscall"
	"time"
)

func main() {
	cfg, err := config.ReadConfig("FBAA_")
	if err != nil {
		fmt.Printf("error reading config: %v\n", err)
		return
	}

	grpcClient, err := fbaa.NewGrpcClient(cfg.Address, cfg.Port)
	if err != nil {
		fmt.Printf("error creating gRPC client: %v\n", err)
		return
	}

	fmt.Printf("Fantastic Beasts Discovery Servive started (%s:%d)...\n", cfg.Address, cfg.Port)

	r := randomizer.NewRandomizer()

	interruptChannel := make(chan os.Signal, 1)
	signal.Notify(interruptChannel, os.Interrupt, syscall.SIGTERM)

	ticker := time.NewTicker(time.Duration(cfg.Interval) * time.Second)
	defer ticker.Stop()

	for {
		select {
		case <-ticker.C:
			go func() {
				newCreature := r.RandomCreature()
				fmt.Printf("%s the %s discovered\n", newCreature.Name, newCreature.Species)

				err = grpcClient.AddCreature(newCreature)
				if err != nil {
					fmt.Printf("error adding new creature: %v\n", err)
				}
			}()

		case <-interruptChannel:
			fmt.Println("Stopping Fantastic Beasts Discovery Servive...")
			return
		}
	}

}
