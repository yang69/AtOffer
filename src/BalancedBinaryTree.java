/**
 * Created by Yang on 2017/4/22.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    /**
     * 用后序遍历的方式遍历二叉树的每一个结点
     * @param root
     * @param depth
     * @return
     */
    private boolean isBalanced(TreeNode root, int[] depth) {
        if(root == null) {
            depth[0] = 0;
            return true;
        }
        int[] depthOfLeftSubtree = new int[1];
        int[] depthOfRightSubtree = new int[1];
        if(isBalanced(root.left, depthOfLeftSubtree) && isBalanced(root.right, depthOfRightSubtree)) {
            int diff = depthOfLeftSubtree[0] - depthOfRightSubtree[0];
            if(diff <= 1 && diff >= -1) {
                depth[0] = 1 + (diff > 0 ? depthOfLeftSubtree[0] : depthOfRightSubtree[0]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        tree.left.right.left = new TreeNode(7);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(tree)); // true
        tree.left = null;
        System.out.println(balancedBinaryTree.isBalanced(tree)); // false
        tree.right = null;
        System.out.println(balancedBinaryTree.isBalanced(tree)); // true
        tree = null;
        System.out.println(balancedBinaryTree.isBalanced(tree)); // true
    }
}
