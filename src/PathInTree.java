import java.util.ArrayList;

/**
 * Created by Yang on 2017/4/17.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {
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

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        findPath(root, target, res, new ArrayList<Integer>(), 0);

        return res;
    }
    private void findPath(TreeNode root, int expectedSum,
                          ArrayList<ArrayList<Integer>> allPaths,
                          ArrayList<Integer> tempPath, int currentSum) {
        currentSum += root.val;
        tempPath.add(root.val);

        // 如果是叶子结点，并且路径上结点的和等于输入的值，则找到一条路径
        boolean isLeaf = root.left == null && root.right == null;
        if(currentSum == expectedSum && isLeaf) {
            allPaths.add(new ArrayList<>(tempPath));
        }

        // 如果不是叶子结点，则遍历它的子结点
        if(root.left != null) {
            findPath(root.left, expectedSum, allPaths, tempPath, currentSum);
        }
        if(root.right != null) {
            findPath(root.right, expectedSum, allPaths, tempPath, currentSum);
        }

        // 在返回到父结点之前，从路径中删除当前结点
        tempPath.remove(tempPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(12);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(7);

        PathInTree pathInTree = new PathInTree();

        // [[10, 5, 7], [10, 12]]
        System.out.println(pathInTree.findPath(tree, 22));
        // []
        System.out.println(pathInTree.findPath(tree, 17));
        // []
        System.out.println(pathInTree.findPath(null, 0));
    }
}
