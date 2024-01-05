package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_setZeroes(t *testing.T) {
	type args struct {
		input  [][]int
		output [][]int
	}
	tests := []struct {
		name string
		args args
	}{
		{
			name: "basic",
			args: args{
				input: [][]int{
					{1, 1, 1}, {1, 0, 1}, {1, 1, 1},
				},
				output: [][]int{
					{1, 0, 1}, {0, 0, 0}, {1, 0, 1},
				},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			setZeroes(tt.args.input)
			assert.Equal(t, tt.args.output, tt.args.input)
		})
	}
}
