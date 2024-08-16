package main

import (
    "sort"
)

func threeSumClosest(nums []int, target int) int {
    // sort the array
    sort.Ints(nums)
    // set the closest value to the maximum value
    closest := 1<<31 - 1
    // iterate through the array
    for i := 0; i < len(nums)-2; i++ {
        // set the left and right pointers
        left, right := i+1, len(nums)-1
        // iterate through the array
        for left < right {
            // calculate the sum
            sum := nums[i] + nums[left] + nums[right]
            // if the sum is equal to the target, return the sum
            if sum == target {
                return sum
            }
            // if the sum is less than the target, increment the left pointer
            if sum < target {
                left++
            } else {
                // if the sum is greater than the target, decrement the right pointer
                right--
            }
            // if the absolute difference between the sum and the target is less than the absolute difference between the closest value and the target, set the closest value to the sum
            if abs(sum-target) < abs(closest-target) {
                closest = sum
            }
        }
    }
    return closest
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
