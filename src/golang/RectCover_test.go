package AtOffer

import "testing"

// go test RectCover_test.go RectCover.go -v -cover

func TestRectCover(t *testing.T) {
	for _, test := range []struct{
		input int
		expected int
	}{
		{0, 0},
		{1, 1},
		{2, 2},
		{3, 3},
		{4, 5},
		{5, 8},
	} {
		result := RectCover(test.input)
		if result != test.expected {
			t.Errorf("RectCover(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
