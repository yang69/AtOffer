package AtOffer

import "testing"

// go test ReplaceSpace_test.go ReplaceSpace.go -v -cover

func TestReplaceSpace(t *testing.T) {
	for _, test := range []struct {
		str string
		expected string
	}{
		{"t r s","t%20r%20s"},
		{" ", "%20"},
		{"", ""},
		{"a", "a"},
	} {
		result := ReplaceSpace(test.str)
		if result != test.expected {
			t.Errorf("Replace(%q) = %q, expected: %q", test.str, result, test.expected)
		}
	}
}
