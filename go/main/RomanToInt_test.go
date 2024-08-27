package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestRomanToInt(t *testing.T) {
	tests := []struct {
		name string
		s    string
		want int
	}{
		{
			name: "Test 1",
			s:    "III",
			want: 3,
		},
		{
			name: "Test 2",
			s:    "IV",
			want: 4,
		},
		{
			name: "Test 3",
			s:    "LVIII",
			want: 58,
		},
		{
			name: "Test 4",
			s:    "MCMXCIV",
			want: 1994,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			assert.Equal(t, test.want, romanToInt(test.s))
		})
	}
}
