package main

type MinStack struct {
	arr    []int
	minArr []int
}

func Constructor() MinStack {
	return MinStack{
		arr:    make([]int, 0),
		minArr: make([]int, 0),
	}
}

func (this *MinStack) Push(val int) {
	if len(this.minArr) == 0 {
		this.minArr = append(this.minArr, val)
	} else {
		min := this.minArr[len(this.minArr)-1]
		if val < min {
			this.minArr = append(this.minArr, val)
		} else {
			this.minArr = append(this.minArr, min)
		}
	}
	this.arr = append(this.arr, val)
}

func (this *MinStack) Pop() {
	if len(this.arr) == 0 {
		return
	}
	this.minArr = this.minArr[:len(this.minArr)-1]
	this.arr = this.arr[:len(this.arr)-1]
}

func (this *MinStack) Top() int {
	if len(this.arr) == 0 {
		panic("empty stack")
	}
	return this.arr[len(this.arr)-1]
}

func (this *MinStack) GetMin() int {
	return this.minArr[len(this.minArr)-1]
}
