/**
 * @author yang
 * @version 0.1 20180721
 * Created by yang on 2017/07/21.
 ************************************************************************************************
 * 输入一个链表，从尾到头打印链表每个节点的值。
 ************************************************************************************************
 */
package AtOffer

import (
	"strconv"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l *ListNode) String() string {
	if nil == l {
		return "nil"
	}
	return strconv.Itoa(l.Val) + "->" + l.Next.String()
}

func PrintListFromTailToHead(list *ListNode) []int {
	reversedList, _ := reverseList(list)
	var res []int

	node := reversedList
	for nil != node {
		res = append(res, node.Val)
		node = node.Next
	}

	return res
}

func reverseList(head *ListNode) (reversedHead *ListNode, length int) {
	if nil == head || nil == head.Next {
		length = 0
		if nil != head {
			length = 1
		}
		return head, length
	}

	currNode, length := head, 0
	var prevNode, nextNode *ListNode
	for nil != currNode {
		length++
		nextNode = currNode.Next
		if nil != nextNode {
			reversedHead = nextNode
		}
		currNode.Next = prevNode
		prevNode = currNode
		currNode = nextNode
	}

	return reversedHead, length
}
