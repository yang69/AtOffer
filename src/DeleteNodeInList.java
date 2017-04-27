/**
 * Created by Yang on 2017/4/15.
 * 在O(1)时间删除链表结点：
 *
 * 给定单向链表的头指针和一个结点指针，
 * 定义一个函数在O(1)时间删除该结点。
 *
 * 【思路】
 *      正常删除链表结点都得给个头指针和要删除的结点，然后从头开始遍历寻找
 *      但是要求时间复杂度是1，
 *      我们可以直接复制这个结点的下一个结点，然后再将这个结点的下一个结点删除。
 * 【注意】
 * - 要删除的结点是尾结点
 *     - 没办法，NULL为系统中的特定的那块区域！！并无法复制，所以只能从头遍历，得到该结点的前序结点，删除。
 *     - 如果链表只有一个结点，即这个要删除的结点也是头结点，则，将nodeToBeDeleted置为空之后，还需把头结点置为空；
 * - 由于Java子函数，只能是值传递，（所以不像C++，）必须返回新链表头结点，不然子函数就白调用了。
 */
public class DeleteNodeInList {
    public ListNode deleteNode(ListNode listHead, ListNode toBeDeleted) {
        // 1. 链表为空或者要删除的结点为空，则什么都不要做
        if(listHead == null || toBeDeleted == null)
            return listHead;
        // 2. 要删除的是头结点，直接返回头结点的下一个结点
        if(listHead == toBeDeleted) {
            return listHead.next;
        }
        // 3. 要删除的不是尾结点，则将下一个结点的值覆盖到当前结点，并删除下一个结点，时间复杂度O(1)
        if(toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        // 4. 要删除的是尾结点，则需要从头结点开始遍历，找到倒数第二个结点，将倒数第二个节点的next指针设为null，时间复杂度O(n)
        } else {
            toBeDeleted = listHead;
            while(toBeDeleted.next.next != null) {
                toBeDeleted = toBeDeleted.next;
            }
            toBeDeleted.next = null;
        }
        return listHead;
    }

    public static void main(String[] args) {
        DeleteNodeInList deleteNodeInList = new DeleteNodeInList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        // 1, 2, 3, 3, 4, 4, 5
        System.out.println(head + " <--> 1, 2, 3, 3, 4, 4, 5");
        // 1, 2, 3, 4, 4, 5
        System.out.println(deleteNodeInList.deleteNode(head, head.next.next) + " <--> 1, 2, 3, 4, 4, 5");
        // 1, 2, 4, 4, 5
        System.out.println(deleteNodeInList.deleteNode(head, head.next.next) + " <--> 1, 2, 4, 4, 5");
        // 1, 2, 4, 5
        System.out.println(deleteNodeInList.deleteNode(head, head.next.next.next) + " <--> 1, 2, 4, 5");
        // 1, 2, 4
        System.out.println(deleteNodeInList.deleteNode(head, head.next.next.next) + " <--> 1, 2, 4");
        // 2, 4
        head = head.next;
        // 4
        System.out.println(deleteNodeInList.deleteNode(head, head) + " <--> 4");
        // 4
        head = head.next;
        // null
        System.out.println(deleteNodeInList.deleteNode(head.next, head.next) + " <--> null");
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        public String toString() {
            if(next == null) {
                return val + "";
            }
            return val + ", " + this.next;
        }
    }
}
