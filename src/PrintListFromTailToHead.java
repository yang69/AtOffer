import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 当可以修改链表时，可以先把链表反转，再顺序添加到ArrayList中
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode reversedList = reverseList(listNode);
        ArrayList<Integer> res = new ArrayList<>();
        while(reversedList != null) {
            res.add(reversedList.val);
            reversedList = reversedList.next;
        }
        return res;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = null;
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(currNode != null) {
            nextNode = currNode.next;
            if(nextNode != null) {
                reversedHead = nextNode;
            }
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        return reversedHead;
    }

    /**
     * 不修改链表，借助Stack的辅助，先顺序放入Stack中，再从Stack中拿出，就是逆序的。
     * 这里用LinkedList就足够了，LinkedList是个链表，在头部插入元素的复杂度是O(1)。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return new ArrayList<>(stack);
    }

    /**
     * 不修改链表、不用辅助存储空间，可以先把链表反转，再顺序添加到ArrayList中，再把链表反转
     * PS：这么做是有问题的，不允许你修改，而你事实上修改了。如果你修改的过程中有什么地方在读这个链表你就GG了
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode reversedList = reverseList(listNode);
        ArrayList<Integer> res = new ArrayList<>();
        ListNode node = reversedList;
        while(node != null) {
            res.add(node.val);
            node = node.next;
        }
        reverseList(reversedList);
        return res;
    }

    /**
     * 时间效率很差的解法，O(n^2)
     * ArrayList底层使用数组实现，每次都在开头插入的话，后面的每一个元素都要向后移动，时间效率很差
     * 用LinkedList替换ArrayList就没有问题了。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        for (int i = 1; i < 100; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        System.out.println("[" + listNode + "]");
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead2(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead3(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead1(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode));

        System.out.println("[" + listNode + "]");
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead2(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead3(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead1(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode));

        listNode.next = new ListNode(2);
        System.out.println("[" + listNode + "]");
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead2(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead3(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead1(listNode));
        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode));
    }
}
