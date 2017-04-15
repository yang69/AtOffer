/**
 * Created by Yang on 2017/4/15.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        public String toString() {
            return val+"";
        }
    }
    public ListNode findKthToTail(ListNode head,int k) {
        if(head == null || k == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k - 1; i++) {
            if(fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(int i = 1; i < 12; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(findKthToTail.findKthToTail(head, 1));
        System.out.println(findKthToTail.findKthToTail(head, 2));
        System.out.println(findKthToTail.findKthToTail(head, 0));
        System.out.println(findKthToTail.findKthToTail(head, 12));
        System.out.println(findKthToTail.findKthToTail(head, 13));
    }
}
