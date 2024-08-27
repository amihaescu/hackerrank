package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLongestCommonPrefix(t *testing.T) {
	tests := []struct {
		name string
		strs []string
		want string
	}{
		{
			name: "Test 1",
			strs: []string{"flower", "flow", "flight"},
			want: "fl",
		},
		{
			name: "Test 2",
			strs: []string{"dog", "racecar", "car"},
			want: "",
		},
		{
			name: "Test 3",
			strs: []string{"a"},
			want: "a",
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.want, longestCommonPrefix(test.strs))
		})
	}
}
