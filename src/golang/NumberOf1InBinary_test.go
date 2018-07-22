package AtOffer

import "testing"

func TestNumberOf1InBinary(t *testing.T) {
	for _, test := range []struct{
		input int
		expected int
	}{
		{0, 0},
		{0x7FFFFFFF, 31},
		{0x80000000, 1},
		{0xFFFFFFFF, 32},
	} {
		result := NumberOf1InBinary(test.input)
		if result != test.expected {
			t.Errorf("NumberOf1InBinary(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
