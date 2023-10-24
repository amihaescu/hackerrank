package main

import "fmt"

func isPalindrome(x int) bool {
	stringX := fmt.Sprintf("%d", x)
	length := len(stringX)
	if length == 0 || length == 1 {
		return true
	}
	for i := 0; i < length/2; i++ {
		if stringX[i] != stringX[length-i-1] {
			return false
		}
	}
	return true
}
