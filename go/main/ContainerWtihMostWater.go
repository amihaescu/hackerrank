package main

import "fmt"

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

type Car interface {
	GetModel() string
}

type SportsCar struct {
	Model string
}

func (s *SportsCar) GetModel() string {
	return s.Model
}

func main() {
	c := make(chan int)
	go printingFunction(c)
	fmt.Println("Sending data to the channel...")
	for i := 0; i < 10; i++ {
		c <- i
	}
}

func printingFunction(c chan int) {
	fmt.Println("Awaiting for data to be sent to the channel...")
	for i := range c {
		fmt.Println(i)
	}
}
