package main

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	m := map[byte]string{
		'2': "abc", '3': "def", '4': "ghi", '5': "jkl",
		'6': "mno", '7': "pqrs", '8': "tuv", '9': "wxyz",
	}
	res := []string{""}
	for i := 0; i < len(digits); i++ {
		d := digits[i]
		letters := m[d]
		size := len(res)
		for j := 0; j < size; j++ {
			for k := 0; k < len(letters); k++ {
				res = append(res, res[j]+string(letters[k]))
			}
		}
		res = res[size:]
	}
	return res
}
