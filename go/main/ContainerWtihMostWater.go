package main

func maxArea(height []int) int {
	left := 0
	right := len(height) - 1
	maxArea := 0
	for left < right {
		maxArea = max(maxArea, (right-left)*min(height[left], height[right]))
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return maxArea
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
