package AtOffer

import "testing"

// go test Power_test.go Power.go -v -cover

func TestPower(t *testing.T) {
	for _, test := range []struct{
		base float64
		exponent int
		expected float64
	}{
		{2.34, 0, 1.0},
		{3.88, 1, 3.88},
		{2.0, 3, 8.0},
		{2.0, -3, 0.125},
	} {
		result, _ := Power(test.base, test.exponent)
		if !floatEqual(result, test.expected) {
			t.Errorf("Power(%v, %v) = %v, expected: %v", test.base, test.exponent, result, test.expected)
		}
	}
}
