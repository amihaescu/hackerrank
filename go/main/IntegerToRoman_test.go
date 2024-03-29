package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestIntegerToRoman(t *testing.T) {
	tests := []struct {
		name string
		num  int
		want string
	}{
		{"Test 1", 3, "III"},
		{"Test 2", 4, "IV"},
		{"Test 3", 58, "LVIII"},
		{"Test 4", 1994, "MCMXCIV"},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.want, intToRoman(test.num))
		})
	}
}
