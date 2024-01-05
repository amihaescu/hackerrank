package main

/**
 * 54. Spiral Matrix
 */
func spiralOrder(matrix [][]int) []int {
	var answer []int
	if len(matrix) == 0 {
		return answer
	}
	top, bottom, left, right := 0, len(matrix)-1, 0, len(matrix[0])-1
	for top <= bottom && left <= right {
		for i := left; i <= right; i++ {
			answer = append(answer, matrix[top][i])
		}
		top++
		for i := top; i <= bottom; i++ {
			answer = append(answer, matrix[i][right])
		}
		right--
		if top <= bottom {
			for i := right; i >= left; i-- {
				answer = append(answer, matrix[bottom][i])
			}
			bottom--
		}
		if left <= right {
			for i := bottom; i >= top; i-- {
				answer = append(answer, matrix[i][left])
			}
			left++
		}
	}
	return answer

}
