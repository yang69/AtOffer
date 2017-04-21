/**
 * Created by Yang on 2017/4/21.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodesInLists {
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

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);

        int lengthDiff = length1 - length2;
        ListNode longListHead = pHead1;
        ListNode shortListHead = pHead2;
        if(length1 < length2) {
            lengthDiff = length2 - length1;
            longListHead = pHead2;
            shortListHead = pHead1;
        }

        for (int i = 0; i < lengthDiff; i++) {
            longListHead = longListHead.next;
        }

        while(longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        ListNode firstCommonNode = longListHead;
        return firstCommonNode;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public static void main(String[] args) {
        FirstCommonNodesInLists firstCommonNodesInLists = new FirstCommonNodesInLists();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(7);

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = list1.next.next.next;

        System.out.println(firstCommonNodesInLists.findFirstCommonNode(list1, list2));
    }
}
