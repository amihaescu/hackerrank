package main

func findDuplicate(nums []int) int {
	answer := 0
	for _, num := range nums {
		answer ^= num
	}
	for i := 1; i < len(nums); i++ {
		answer ^= i
	}
	return answer
}
