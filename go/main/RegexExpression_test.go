package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestRegexExpression(t *testing.T) {
	tests := []struct {
		name string
		s    string
		p    string
		want bool
	}{
		{
			name: "Example 1",
			s:    "aa",
			p:    "a",
			want: false,
		},
		{
			name: "Example 2",
			s:    "aa",
			p:    "a*",
			want: true,
		},
		{
			name: "Example 3",
			s:    "ab",
			p:    ".*",
			want: true,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.want, isMatch(test.s, test.p))
		})
	}
}
