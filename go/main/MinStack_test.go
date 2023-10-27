package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test(t *testing.T) {
	tests := []struct {
		name    string
		actions []string
		values  []int
		results []int
	}{
		{
			name:    "basic",
			actions: []string{"MinStack", "push", "push", "top", "getMin", "pop", "getMin", "top"},
			values:  []int{0, 1, 2, 0, 0, 0, 0, 0},
			results: []int{0, 0, 0, 2, 1, 0, 1, 1},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			var minStack MinStack
			for i, action := range test.actions {
				switch action {
				case "MinStack":
					minStack = Constructor()
				case "push":
					minStack.Push(test.values[i])
				case "pop":
					minStack.Pop()
				case "top":
					top := test.results[i]
					assert.Equal(t, top, minStack.Top())
				case "getMin":
					minValue := test.results[i]
					assert.Equal(t, minValue, minStack.GetMin())
				}
			}
		})
	}
}
