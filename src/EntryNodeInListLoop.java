/**
 * Created by Yang on 2017/4/25.
 * 链表中环的入口结点：
 *
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeInListLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return null;
        }

        // 找出环中的一个结点
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while(fast != null && slow != fast) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            }
        }
        if(fast == null) { // 无环
            return null;
        }

        // 找出环的长度
        int length = 0;
        slow = fast;
        do {
            fast = fast.next;
            length++;
        } while(fast != slow);

        // 找出环的入口结点，让快的指针在慢的指针前length个结点处，相遇的时候正好在环的入口
        fast = pHead;
        for (int i = 0; i < length; i++) {
            fast = fast.next;
        }
        slow = pHead;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        EntryNodeInListLoop entryNodeInListLoop = new EntryNodeInListLoop();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;

        System.out.println(head.next);
        System.out.println(entryNodeInListLoop.entryNodeOfLoop(head));
        System.out.println();

        head.next = head;
        System.out.println(head);
        System.out.println(entryNodeInListLoop.entryNodeOfLoop(head));
        System.out.println();

        head.next = null;
        System.out.println((Object)null);
        System.out.println(entryNodeInListLoop.entryNodeOfLoop(head));
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
//        public String toString() {
//            return val+"";
//        }
    }
}
