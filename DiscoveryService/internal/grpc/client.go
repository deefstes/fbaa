package fbaa

import (
	"context"
	"fbaa/models"
	"fmt"

	"google.golang.org/grpc"
)

type GrpcClient struct {
	client FBAAClient
}

// NewGrpcClient creates and returns a new GrpcClient pointing at the specified address on the specified port
func NewGrpcClient(baseUrl string, port int) (GrpcClient, error) {
	c := GrpcClient{}

	conn, err := grpc.Dial(
		fmt.Sprintf("%s:%d", baseUrl, port),
		grpc.WithInsecure(),
	)
	if err != nil {
		return c, fmt.Errorf("creating gRPC client: %w", err)
	}

	c.client = NewFBAAClient(conn)

	return c, nil
}

func (c *GrpcClient) AddCreature(creature models.Creature) error {
	grpcCreature := AddCreatureRequest{
		Name:        creature.Name,
		Rarity:      Rarity(creature.Rarity),
		Species:     creature.Species,
		Description: creature.Description,
		Attributes:  creature.Attributes,
		Age:         creature.Age,
	}

	for _, a := range creature.Abilities {
		grpcCreature.Abilities = append(grpcCreature.Abilities, SpecialAbility(a))
	}

	_, err := c.client.AddCreature(
		context.Background(),
		&grpcCreature,
	)
	if err != nil {
		return fmt.Errorf("calling gRPC function: %w", err)
	}

	return nil
}
