package main

import "strings"

func intToRoman(num int) string {
	var sb strings.Builder
	corespondingRoman :=
		[]IntegerToRoman{
			{1000, "M"},
			{900, "CM"},
			{500, "D"},
			{400, "CD"},
			{100, "C"},
			{90, "XC"},
			{50, "L"},
			{40, "XL"},
			{10, "X"},
			{9, "IX"},
			{5, "V"},
			{4, "IV"},
			{1, "I"},
		}
	for _, elem := range corespondingRoman {
		if num >= elem.value {
			thousands := num / elem.value
			if thousands > 0 {
				sb.WriteString(strings.Repeat(elem.roman, thousands))
			}
			num %= elem.value
		}
	}

	return sb.String()
}

type IntegerToRoman struct {
	value int
	roman string
}
