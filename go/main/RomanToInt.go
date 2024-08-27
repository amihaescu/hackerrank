package main

func romanToInt(s string) int {
	value := 0
	corespondingRoman := map[string]int{
		"M":  1000,
		"CM": 900,
		"D":  500,
		"CD": 400,
		"C":  100,
		"XC": 90,
		"L":  50,
		"XL": 40,
		"X":  10,
		"IX": 9,
		"V":  5,
		"IV": 4,
		"I":  1,
	}

	for index := 0; index < len(s); index++ {
		if (index + 1) < len(s) {
			elem := s[index : index+2]
			if val, ok := corespondingRoman[elem]; ok {
				value += val
				index++
				continue
			}
		}
		elem := s[index : index+1]
		if val, ok := corespondingRoman[elem]; ok {
			value += val
		}
	}
	return value
}
