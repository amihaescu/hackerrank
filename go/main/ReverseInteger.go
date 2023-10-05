package main

import (
	"fmt"
)

func reverse(x int) int {
	result := 0
	var num int
	var negative bool
	if x < 0 {
		num = -x
		negative = true
	} else {
		num = x
		negative = false
	}
	for ; num > 0; num /= 10 {
		lastDigit := num % 10
		result = result*10 + lastDigit
	}
	if result > 2147483647 {
		return 0
	}
	if negative {
		return -result
	}
	return result
}

func main() {
	fmt.Print(reverse(1534236469))
}
