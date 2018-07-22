package AtOffer

import "testing"

// run tests by executing command:
// go test SearchInTwoDimensionalArray_test.go SearchInTwoDimensionalArray.go -v -cover

func TestFind(t *testing.T) {
	var tests = []struct{
		array [][]int
		target int
		expected bool
	}{
		{[][]int{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 8, true},
		{[][]int{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 1, true},
		{[][]int{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 12, true},
		{[][]int{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 0, false},
	}
	for _, test := range tests {
		result := Find(test.target, test.array)
		if result != test.expected {
			t.Errorf("Find(%v, %v) = %v, expected: %v", test.target, test.array, result, test.expected)
		}
	}
}
