package main

func myAtoi(s string) int {
	if len(s) == 0 {
		return 0
	}

	isNegative := false
	var result = 0
	var index = 0
	for index < len(s) && s[index] == ' ' {
		index++
	}
	if index == len(s) {
		return 0
	}

	if s[index] == '-' || s[index] == '+' {
		isNegative = s[index] == '-'
		index++
	}
	if index == len(s) {
		return 0
	}
	for i := index; i < len(s); i++ {
		elem := s[i]
		elemInt := int(elem - '0')
		if elemInt >= 0 && elemInt <= 9 {
			result = result*10 + elemInt
			if result > 2147483647 {
				if isNegative {
					return -2147483648
				}
				return 2147483647
			}
		} else if elemInt < 0 || elemInt > 9 || elem != ' ' {
			return returnResult(isNegative, result)
		}
	}
	return returnResult(isNegative, result)
}

func returnResult(isNegative bool, result int) int {
	if isNegative {
		return -result
	}
	return result
}

func main() {
	print(myAtoi("  +  413"))
}
