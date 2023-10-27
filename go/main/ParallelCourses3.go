/*
* https://leetcode.com/problems/parallel-courses-iii/
 */
package main

func minimumTime(n int, relations [][]int, time []int) int {
	finishTime := make([]int, n+1)
	for i := 0; i < len(finishTime); i++ {
		finishTime[i] = -1
	}
	depMap := make(map[int][]int)
	for _, relation := range relations {
		ints, ok := depMap[relation[1]]
		if !ok {
			ints = make([]int, 0)
			ints = append(ints, relation[0])
			depMap[relation[1]] = ints
		} else {
			ints = append(ints, relation[0])
			depMap[relation[1]] = ints
		}
	}
	result := 0
	for i := 1; i <= len(time); i++ {
		finishTime[i] = computeFinish(i, depMap, time, finishTime)
		result = max(result, finishTime[i])
	}
	return result
}

func computeFinish(node int, deps map[int][]int, time []int, finishTime []int) int {
	if finishTime[node] != -1 {
		return finishTime[node]
	}

	delay := 0
	for _, dep := range deps[node] {
		delay = max(delay, computeFinish(dep, deps, time, finishTime))
	}
	finishTime[node] = delay + time[node-1]
	return finishTime[node]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
