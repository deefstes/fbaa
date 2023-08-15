package randomizer

import (
	"fmt"
	"testing"
)

func TestRandomizer_randomAbility(t *testing.T) {
	c := NewRandomizer()
	for i := 0; i < 100; i++ {
		fmt.Println(c.randomAbility())
	}
}
