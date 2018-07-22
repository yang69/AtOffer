package AtOffer

import (
	"testing"
	"reflect"
)

// go test ReConstructBinaryTree_test.go ReConstructBinaryTree.go -v -cover

func TestReConstructBinaryTree(t *testing.T) {
	for _, test := range []struct{
		preorder []int
		inorder []int
		expected *TreeNode
	}{
		{[]int{1,2,4,7,3,5,6,8}, []int{4,7,2,1,5,3,8,6}, &TreeNode{Val:1,Left:&TreeNode{Val:2,Left:&TreeNode{Val:4,Right:&TreeNode{Val:7}}}, Right:&TreeNode{Val:3,Left:&TreeNode{Val:5},Right:&TreeNode{Val:6,Left:&TreeNode{Val:8}}}}},
	} {
		result := ReConstructBinaryTree(test.preorder, test.inorder)
		if !reflect.DeepEqual(result, test.expected) {
			t.Errorf("ReConstructBinaryTree(%v, %v) = %v, expected: %v", test.preorder, test.inorder, result, test.expected)
		}
	}
}
