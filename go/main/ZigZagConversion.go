package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Print(convert("PAYPALISHIRING", 4))
}

func convert(s string, numRows int) string {
	var result strings.Builder
	if numRows == 1 {
		return s
	}
	n := len(s)
	diff := 2 * (numRows - 1)
	for i := 0; i < numRows; i++ {
		for index := i; index < n; index += diff {
			result.WriteByte(s[index])
			if i != 0 && i != numRows-1 {
				secondIndex := index + diff - 2*i
				if secondIndex < n {
					result.WriteByte(s[secondIndex])
				}
			}
		}
	}
	return result.String()
}
