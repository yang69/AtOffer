package AtOffer

import (
	"testing"
	"reflect"
)

// go test PrintListFromTailToHead_test.go PrintListFromTailToHead.go -v -cover

func TestPrintListFromTailToHead(t *testing.T) {
	for _, test := range []struct{
		input *ListNode
		expected []int
	}{
		{&ListNode{1, nil}, []int{1}},
		{&ListNode{1, &ListNode{2, nil}}, []int{2, 1}},
		{&ListNode{1, &ListNode{2, &ListNode{3, nil}}}, []int{3,2,1}},
	} {
		result := PrintListFromTailToHead(test.input)
		if !reflect.DeepEqual(result, test.expected) {
			t.Errorf("PrintListFromTailToHead(%v) = %v, expected: %v", test.input, result, test.expected)
		}
	}
}
