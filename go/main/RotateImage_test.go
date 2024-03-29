package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_rotate(t *testing.T) {
	type args struct {
		matrix [][]int
	}
	tests := []struct {
		name  string
		args  args
		wants [][]int
	}{
		{
			name: "first",
			args: args{
				matrix: [][]int{
					{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
				},
			},
			wants: [][]int{
				{7, 4, 1}, {8, 5, 2}, {9, 6, 3},
			},
		},
		{
			name: "second",
			args: args{
				matrix: [][]int{
					{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16},
				},
			},
			wants: [][]int{
				{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			rotate(tt.args.matrix)
			assert.Equal(t, tt.wants, tt.args.matrix)
		})
	}
}
