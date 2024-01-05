package main

/**
 * 48. Rotate Image
 */

func rotate(matrix [][]int) {
	printMatrix(matrix)
	for i := 0; i < len(matrix)/2; i++ {
		for j := i; j < len(matrix)-1-i; j++ {
			rotateFour(matrix, i, j)
			printMatrix(matrix)
		}
	}
}

func printMatrix(matrix [][]int) {
	for _, row := range matrix {
		for _, num := range row {
			print(num)
			print(" ")
		}
		println()
	}
	println()
}

func rotateFour(matrix [][]int, i int, j int) {
	first := matrix[i][j]
	second := matrix[j][len(matrix)-1-i]
	third := matrix[len(matrix)-1-i][len(matrix)-1-j]
	fourth := matrix[len(matrix)-1-j][i]
	println(first, second, third, fourth)
	println()
	matrix[i][j] = fourth
	matrix[j][len(matrix)-1-i] = first
	matrix[len(matrix)-1-i][len(matrix)-1-j] = second
	matrix[len(matrix)-1-j][i] = third
}
