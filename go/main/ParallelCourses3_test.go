package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestParallelCourses(t *testing.T) {
	tests := []struct {
		name      string
		n         int
		relations [][]int
		time      []int
		result    int
	}{
		{
			name:      "tc0",
			n:         3,
			relations: [][]int{{1, 3}, {2, 3}},
			time:      []int{3, 2, 5},
			result:    8,
		},
		{
			name:      "tc1",
			n:         5,
			relations: [][]int{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}},
			time:      []int{1, 2, 3, 4, 5},
			result:    12,
		},
		{
			name:      "tc2",
			n:         6,
			relations: [][]int{{1, 3}, {3, 2}, {1, 6}},
			time:      []int{1, 8, 4, 7, 2, 6},
			result:    13,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.result, minimumTime(test.n, test.relations, test.time))
		})
	}
}
