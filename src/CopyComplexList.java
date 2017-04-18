/**
 * Created by Yang on 2017/4/17.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyComplexList {
    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead) {
        // 复制每一个结点（忽略random指针），与源结点共同组成一个两倍长度的新链表
        cloneNodes(pHead);
        // 设置random指针
        connectSiblingNodes(pHead);
        // 拆分链表，并返回复制的链表的表头
        return reconnectNodes(pHead);
    }

    /**
     * 复制RandomList的每一个结点(忽略random指针)，并将复制的结点插入到对应的源结点之后
     * @param pHead 待复制的RandomList的头结点
     */
    private void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while(pNode != null) {
            RandomListNode clonedNode = new RandomListNode(pNode.label);
            clonedNode.next = pNode.next;
            clonedNode.random = null;

            pNode.next = clonedNode;

            pNode = clonedNode.next;
        }
    }

    /**
     * 设置复制结点的random指针，
     * 注意到复制结点的random指针应该指向相应的复制结点，
     * 而每一个复制结点都在它对应的源结点的next的位置上。
     * @param pHead
     */
    private void connectSiblingNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while(pNode != null) {
            RandomListNode clonedNode = pNode.next;
            if(pNode.random != null) {
                clonedNode.random = pNode.random.next;
            }

            pNode = clonedNode.next;
        }
    }

    /**
     * 将原链表和复制链表组成的长链表拆分成两个链表：
     * 奇数位置的结点链接起来就是原链表，
     * 偶数位置的结点链接起来就是复制出来的链表。
     * @param pHead 原链表和复制链表组成的长链表的表头
     * @return 复制出的链表的表头
     */
    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;

        if(pNode != null) {
            pClonedHead = pNode.next;
            pClonedNode = pNode.next;

            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while(pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;

            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }

    public static void main(String[] args) {
        RandomListNode A = new RandomListNode(1);
        RandomListNode B = new RandomListNode(2);
        RandomListNode C = new RandomListNode(3);
        RandomListNode D = new RandomListNode(4);
        RandomListNode E = new RandomListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = null;
        A.random = C;
        B.random = E;
        C.random = null;
        D.random = B;
        E.random = null;

        System.out.println("原链表为：");
        RandomListNode pNode = A;
        while(pNode != null) {
            System.out.println(pNode + ": " + pNode.label + ", next -> " + pNode.next + ", random -> " + pNode.random);
            pNode = pNode.next;
        }

        CopyComplexList copyComplexList = new CopyComplexList();
        RandomListNode clonedList = copyComplexList.clone(A);

        System.out.println("复制的链表为：");
        pNode = clonedList;
        while(pNode != null) {
            System.out.println(pNode + ": " + pNode.label + ", next -> " + pNode.next + ", random -> " + pNode.random);
            pNode = pNode.next;
        }

    }
}
