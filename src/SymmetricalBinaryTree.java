/**
 * Created by Yang on 2017/4/25.
 * 对称的二叉树：
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，
 * 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if(pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if(pRoot1.val != pRoot2.val) {
            return false;
        }
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

    public static void main(String[] args) {
        SymmetricalBinaryTree symmetricalBinaryTree = new SymmetricalBinaryTree();

        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(5);

        System.out.println(symmetricalBinaryTree.isSymmetrical(tree) + " <--> true");

        tree.right = new TreeNode(0);
        System.out.println(symmetricalBinaryTree.isSymmetrical(tree) + " <--> false");

        tree = new TreeNode(6);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(6);
        System.out.println(symmetricalBinaryTree.isSymmetrical(tree) + " <--> false");
    }

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
}
