package main

import "testing"

func TestLetterCombination(t *testing.T) {
	tests := []struct {
		name   string
		digits string
		want   []string
	}{
		{
			name:   "Example 1",
			digits: "23",
			want:   []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
		},
		{
			name:   "Example 2",
			digits: "",
			want:   []string{},
		},
		{
			name:   "Example 3",
			digits: "2",
			want:   []string{"a", "b", "c"},
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assertEqual(t, letterCombinations(test.digits), test.want)
		})
	}
}
