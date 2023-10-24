package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_ReverseInteger(t *testing.T) {
	tests := []struct {
		name   string
		input  int
		output int
	}{
		{
			name:   "basic",
			input:  123,
			output: 321,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.output, reverse(test.input))
		})
	}
}
