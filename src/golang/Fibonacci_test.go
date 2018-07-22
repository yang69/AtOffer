package AtOffer

import "testing"

// go test Fibonacci_test.go Fibonacci.go -v -cover

func TestFibonacci(t *testing.T) {
	for _, test := range []struct{
		input int
		expected int
	}{
		{0, 0},
		{1, 1},
		{2, 1},
		{3, 2},
		{4, 3},
		{5, 5},
		{6, 8},
		{7, 13},
		{8, 21},
		{9, 34},
		{10, 55},
		{11, 89},
		{12, 144},
		{13, 233},
		{14, 377},
		{15, 610},
	} {
		result := Fibonacci(test.input)
		if result != test.expected {
			t.Errorf("Fibonacci(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
