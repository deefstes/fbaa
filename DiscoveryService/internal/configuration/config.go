package config

import (
	"fmt"
	"os"
	"strconv"
)

type Configuration struct {
	Address string
	Port    int
}

type DBConfig struct {
	DBMS      string
	ConString string
}

func ReadConfig(prefix string) (Configuration, error) {
	var cfg Configuration

	p := os.Getenv(prefix + "PORT")
	// Set port to default value of 80 if no value is provided
	if p == "" {
		p = "80"
	}
	port, err := strconv.ParseInt(p, 10, 64)
	if err != nil {
		return Configuration{}, fmt.Errorf("unable to parse value for %sPORT (%s)", prefix, os.Getenv(prefix+"PORT"))
	}
	cfg.Port = int(port)

	cfg.Address = os.Getenv(prefix + "ADDRESS")
	if cfg.Address == "" {
		cfg.Address = "127.0.0.1"
	}

	return cfg, nil
}
