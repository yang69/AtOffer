/**
 * Created by Yang on 2017/4/25.
 * 删除链表中重复的结点：
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicatedListNode {
    /**
     * 1.从头结点开始，寻找重复的值x
     * 2.一旦找到重复的值x，删除所有值为x的节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = pHead;
        ListNode curr = pHead;
        ListNode prev = fakeHead;
        while(curr != null) {
            // 1. 找到重复的结点
            if(curr.next != null && curr.val == curr.next.val) { // 重复的结点
                int needToDelete = curr.val;
                // 2. 删除所有至为needToDelete的结点
                while(curr != null && curr.val == needToDelete) {
                    prev.next = curr.next;
                    curr = prev.next;
                }
            } else { // 当前结点与下一结点不重复
                prev = curr;
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        DeleteDuplicatedListNode deleteDuplicatedListNode = new DeleteDuplicatedListNode();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicatedListNode.deleteDuplication(head));

        head.next.next = new ListNode(2);
        System.out.println(deleteDuplicatedListNode.deleteDuplication(head));

        head.next = new ListNode(1);
        System.out.println(deleteDuplicatedListNode.deleteDuplication(head));

        head.next.next = new ListNode(1);
        System.out.println(deleteDuplicatedListNode.deleteDuplication(head));
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
