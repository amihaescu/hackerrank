package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_ZigZagConversion(t *testing.T) {
	tests := []struct {
		name    string
		input   string
		numRows int
		output  string
	}{
		{
			name:    "basic",
			input:   "PAYPALISHIRING",
			numRows: 4,
			output:  "PINALSIGYAHRPI",
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.output, convert(test.input, test.numRows))
		})
	}
}
