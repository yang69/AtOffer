package AtOffer

import "testing"

// go test JumpFloor_test.go JumpFloor.go -v -cover

func TestJumpFloor(t *testing.T) {
	for _, test := range []struct{
		input int
		expected int
	}{
		{0, 0},
		{1, 1},
		{2, 2},
		{3, 3},
		{4, 5},
	} {
		result := JumpFloor(test.input)
		if result != test.expected {
			t.Errorf("JumpFloor(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
