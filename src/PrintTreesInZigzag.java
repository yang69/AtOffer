import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Yang on 2017/4/25.
 * 按之字形顺序打印二叉树：
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层
 * 按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreesInZigzag {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) {
            return res;
        }

        Stack<TreeNode> nodesInCurrentLevel = new Stack<>();
        Stack<TreeNode> nodesInNextLevel = new Stack<>();
        nodesInCurrentLevel.add(pRoot);
        ArrayList<Integer> levelNodes = new ArrayList<>();
        int toBePrinted = 1;
        int nextLevel = 0;
        int level = 1;
        while(nodesInCurrentLevel.size() != 0) {
            TreeNode node = nodesInCurrentLevel.peek();
            levelNodes.add(node.val);
            if((level & 0x1) != 0) {
                if(node.left != null) {
                    nodesInNextLevel.add(node.left);
                    nextLevel++;
                }
                if(node.right != null) {
                    nodesInNextLevel.add(node.right);
                    nextLevel++;
                }
            } else {
                if(node.right != null) {
                    nodesInNextLevel.add(node.right);
                    nextLevel++;
                }
                if(node.left != null) {
                    nodesInNextLevel.add(node.left);
                    nextLevel++;
                }
            }

            nodesInCurrentLevel.pop();
            toBePrinted--;
            if(toBePrinted == 0) {
                level++;
                res.add(new ArrayList<>(levelNodes));
                levelNodes.clear();
                nodesInCurrentLevel = nodesInNextLevel;
                toBePrinted = nextLevel;
                nodesInNextLevel = new Stack<>();
                nextLevel = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PrintTreesInZigzag printTreesInLines = new PrintTreesInZigzag();

        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);

        System.out.println(printTreesInLines.print(tree) + " <--> [[8], [10, 6], [5, 7, 9, 11]]");
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
