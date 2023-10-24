package main

func productExceptSelf(nums []int) []int {
	var result = make([]int, len(nums))
	result[0] = 1
	for i := 1; i < len(nums); i++ {
		result[i] = result[i-1] * nums[i-1]
	}

	suffixProduct := 1

	for j := len(nums) - 1; j >= 0; j-- {
		result[j] = result[j] * suffixProduct
		suffixProduct *= nums[j]
	}
	return result
}
