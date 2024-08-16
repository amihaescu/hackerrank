package main

import (
    "github.com/stretchr/testify/assert"
    "testing"
)

func TestThreeSumClosest(t *testing.T) {
    tests := []struct {
        name   string
        nums   []int
        target int
        result int
    }{
        {
            name:   "first",
            nums:   []int{-1, 2, 1, -4},
            target: 1,
            result: 2,
        },
        {
            name:   "second",
            nums:   []int{0, 0, 0},
            target: 1,
            result: 0,
        },
    }
    for _, test := range tests {
        t.Run(test.name, func(t *testing.T) {
            threeSumClosest(test.nums, test.target)
            assert.Equal(t, test.result, threeSumClosest(test.nums, test.target))
        })
    }
}
