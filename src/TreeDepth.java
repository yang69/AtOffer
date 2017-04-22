/**
 * Created by Yang on 2017/4/22.
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
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

    public int treeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int depthOfLeftSubtree = treeDepth(root.left);
        int depthOfRightSubtree = treeDepth(root.right);

        return depthOfLeftSubtree > depthOfRightSubtree ? depthOfLeftSubtree + 1 : depthOfRightSubtree + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        tree.left.right.left = new TreeNode(7);

        TreeDepth treeDepth = new TreeDepth();
        System.out.println(treeDepth.treeDepth(tree)); // 4
        tree.left = null;
        System.out.println(treeDepth.treeDepth(tree)); // 3
        tree.right = null;
        System.out.println(treeDepth.treeDepth(tree)); // 1
        tree = null;
        System.out.println(treeDepth.treeDepth(tree)); // 0
    }
}
