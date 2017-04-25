/**
 * Created by Yang on 2017/4/25.
 * 二叉树的下一个结点：
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class NextNodeInBinaryTrees {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null) {
            return null;
        }

        TreeLinkNode next = null;
        if(pNode.right != null) { // 有右子树
            TreeLinkNode node = pNode.right;
            while(node.left != null) {
                node = node.left;
            }
            next = node;
        } else if(pNode.next != null) { // 没有右子树，但有父结点
            TreeLinkNode node = pNode;
            while(node != null && node.next != null && node.next.left != node) {
                node = node.next;
            }
            next = node.next;
        }

        return next;
    }

    public static void main(String[] args) {
        NextNodeInBinaryTrees nextNodeInBinaryTrees = new NextNodeInBinaryTrees();

        TreeLinkNode root = new TreeLinkNode(0);
        root.left = new TreeLinkNode(1);
        root.left.next = root;
        root.right = new TreeLinkNode(2);
        root.right.next = root;
        root.left.left = new TreeLinkNode(3);
        root.left.left.next = root.left;
        root.left.right = new TreeLinkNode(4);
        root.left.right.next = root.left;
        root.right.left = new TreeLinkNode(5);
        root.right.left.next = root.right;
        root.right.right = new TreeLinkNode(6);
        root.right.right.next = root.right;
        root.left.right.left = new TreeLinkNode(7);
        root.left.right.left.next = root.left.right;
        root.left.right.right = new TreeLinkNode(8);
        root.left.right.right.next = root.left.right;

        System.out.println(nextNodeInBinaryTrees.getNext(root.left).val); // 7
        System.out.println(nextNodeInBinaryTrees.getNext(root).val); // 5

        System.out.println(nextNodeInBinaryTrees.getNext(root.left.left).val); // 1
        System.out.println(nextNodeInBinaryTrees.getNext(root.left.right.right).val); // 0
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
