package main

import "sort"

func threeSum(nums []int) [][]int {
	n := len(nums)
	result := [][]int{}
	sort.Ints(nums)

	for num1Idx := 0; num1Idx < n-2; num1Idx++ {
		if num1Idx > 0 && nums[num1Idx] == nums[num1Idx-1] {
			continue
		}
		num2Idx, num3Idx := num1Idx+1, n-1
		for num2Idx < num3Idx {
			sum := nums[num1Idx] + nums[num2Idx] + nums[num3Idx]
			if sum == 0 {
				result = append(result, []int{nums[num1Idx], nums[num2Idx], nums[num3Idx]})

				num3Idx--
				for num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx+1] {
					num3Idx--
				}

			} else if sum > 0 {
				num3Idx--
			} else {
				num2Idx++
			}
		}
	}
	return result
}
