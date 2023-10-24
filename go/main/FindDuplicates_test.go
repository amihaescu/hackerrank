package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_findDuplicate(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "basic",
			args: args{[]int{1, 3, 4, 2, 2}},
			want: 2,
		},
		{
			name: "duplicates",
			args: args{[]int{2, 2, 2, 2, 2}},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			assert.Equalf(t, tt.want, findDuplicate(tt.args.nums), "findDuplicate(%v)", tt.args.nums)
		})
	}
}
