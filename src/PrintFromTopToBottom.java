import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yang on 2017/4/17.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
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

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            res.add(node.val);
            if(node.left != null) {
                nodes.offer(node.left);
            }
            if(node.right != null) {
                nodes.offer(node.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PrintFromTopToBottom printFromTopToBottom = new PrintFromTopToBottom();

        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);

        //[8, 6, 10, 5, 7, 9, 11]
        System.out.println(printFromTopToBottom.printFromTopToBottom(tree));

        tree.left = null;
        //[8, 10, 9, 11]
        System.out.println(printFromTopToBottom.printFromTopToBottom(tree));

        tree.right = null;
        //[8]
        System.out.println(printFromTopToBottom.printFromTopToBottom(tree));

        System.out.println(printFromTopToBottom.printFromTopToBottom(null));
    }
}
