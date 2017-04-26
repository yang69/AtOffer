import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/4/25.
 * 把二叉树打印成多行：
 *
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 */
public class PrintTreesInLines {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) {
            return res;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(pRoot);
        ArrayList<Integer> currentLevel = new ArrayList<>();
        int toBePrinted = 1;
        int nextLevel = 0;
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.peek();
            currentLevel.add(node.val);
            if(node.left != null) {
                nodes.add(node.left);
                nextLevel++;
            }
            if(node.right != null) {
                nodes.add(node.right);
                nextLevel++;
            }
            nodes.poll();
            toBePrinted--;
            if(toBePrinted == 0) {
                res.add(new ArrayList<>(currentLevel));
                currentLevel.clear();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PrintTreesInLines printTreesInLines = new PrintTreesInLines();

        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);

        System.out.println(printTreesInLines.print(tree));
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
