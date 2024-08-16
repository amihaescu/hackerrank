package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestContainerWithMostWater(t *testing.T) {
	tests := []struct {
		name   string
		height []int
		want   int
	}{
		{
			name:   "Example 1",
			height: []int{1, 8, 6, 2, 5, 4, 8, 3, 7},
			want:   49,
		},
		{
			name:   "Example 2",
			height: []int{1, 1},
			want:   1,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			got := maxArea(test.height)
			assert.Equal(t, test.want, got)
		})
	}
}
