package main

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	for index := 0; index < len(strs[0]); index++ {
		for _, str := range strs[1:] {
			if index >= len(str) || strs[0][index] != str[index] {
				return strs[0][:index]
			}
		}
	}
	return strs[0]
}
