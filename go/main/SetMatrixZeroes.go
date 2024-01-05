package main

/**
 * 73. Set Matrix Zeroes
 */
func setZeroes(matrix [][]int) {
	rows := make([]bool, len(matrix))
	cols := make([]bool, len(matrix[0]))
	for i, rowItt := range matrix {
		for j, num := range rowItt {
			if num == 0 {
				rows[i] = true
				cols[j] = true
			}
		}
	}
	for i, row := range matrix {
		for j, _ := range row {
			if rows[i] || cols[j] {
				matrix[i][j] = 0
			}
		}
	}
}
