/**
 * Created by Yang on 2017/4/15.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 二叉树的镜像定义：
 *  源二叉树        镜像二叉树
 *     8               8
 *    / \             / \
 *   6   10         10   6
 *  / \  / \        / \ / \
 * 5  7 9  11      11 9 7  5
 *
 */
public class MirrorOfBinaryTree {
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

    public void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null) {
            mirror(root.left);
        }
        if(root.right != null) {
            mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);

        MirrorOfBinaryTree mirrorOfBinaryTree = new MirrorOfBinaryTree();
        System.out.println(tree);
        mirrorOfBinaryTree.mirror(null);
        mirrorOfBinaryTree.mirror(tree);
        System.out.println(tree);
        tree.left = null;
        System.out.println(tree);
        mirrorOfBinaryTree.mirror(tree);
        System.out.println(tree);
    }
}
