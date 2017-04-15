/**
 * Created by Yang on 2017/4/15.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class SubstructureInTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) { val = x; }
        public String toString() {
            return "[" + left + "," + val + "," + right + "]";
        }
    }

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result) {
                result = hasSubtree(root1.left, root2);
            }
            if(!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }
    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(8);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(9);
        tree1.left.right = new TreeNode(2);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(8);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(2);

        SubstructureInTree substructureInTree = new SubstructureInTree();
        System.out.println(substructureInTree.hasSubtree(null, null));
        System.out.println(substructureInTree.hasSubtree(tree1, null));
        System.out.println(substructureInTree.hasSubtree(null, tree2));
        System.out.println(substructureInTree.hasSubtree(tree1, tree2));
    }
}
