import java.util.ArrayList;

/**
 * Created by yang on 2017/4/8.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {
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

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        System.out.println(listNode);
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode));
    }
}
