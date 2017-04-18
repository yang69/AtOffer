/**
 * Created by Yang on 2017/4/17.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        public String toString() {
            if(left != null && right != null) {
                return "[" + left + "," + val + "," + right + "]";
            } else if(left != null) {
                return "[" + left + "," + val + ",#,]";
            } else if(right != null) {
                return "[#," + val + "," + right + "]";
            } else {
                return "" + val;
            }
        }
    }

    public TreeNode convert(TreeNode pRootOfTree) {
        TreeNode lastNodeInList = convertNode(pRootOfTree, null);

        TreeNode head = lastNodeInList;
        while(head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }
    private TreeNode convertNode(TreeNode node, TreeNode lastNodeInList) {
        if(node == null) {
            return null;
        }

        if(node.left != null) {
            lastNodeInList = convertNode(node.left, lastNodeInList);
        }

        node.left = lastNodeInList;
        if(lastNodeInList != null) {
            lastNodeInList.right = node;
        }
        lastNodeInList = node;
        if(node.right != null) {
            return convertNode(node.right, lastNodeInList);
        }

        return lastNodeInList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        ConvertBinarySearchTree convertBinarySearchTree = new ConvertBinarySearchTree();
        TreeNode deque = convertBinarySearchTree.convert(root);
        while(deque != null) {
            System.out.println(deque.val);
            deque = deque.right;
        }
    }
}
