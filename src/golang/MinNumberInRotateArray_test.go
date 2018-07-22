package AtOffer

import "testing"

func TestMinNumberInRotateArray(t *testing.T) {
	for _, test := range []struct{
		input []int
		expected int
	}{
		{[]int{1,1,2,3,3}, 1},
		{[]int{2,1,1,1}, 1},
		{[]int{1,0,1,1,1}, 0},
		{[]int{3,4,5,1,2}, 1},
	} {
		result := MinNumberInRotateArray(test.input)
		if result != test.expected {
			t.Errorf("MinNumberInRotateArray(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
