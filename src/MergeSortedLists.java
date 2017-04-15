/**
 * Created by Yang on 2017/4/15.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeSortedLists {
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

    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode fakeHead = new ListNode(0);
        ListNode currNode = fakeHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }
            currNode = currNode.next;
        }

        if(list1 != null) {
            currNode.next = list1;
        } else {
            currNode.next = list2;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        System.out.println(mergeSortedLists.merge(null, null));
        System.out.println(mergeSortedLists.merge(null, list2));
        System.out.println(mergeSortedLists.merge(list1, null));
        System.out.println(mergeSortedLists.merge(list1, list2));
    }
}
