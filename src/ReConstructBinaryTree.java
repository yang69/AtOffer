import java.util.HashMap;

/**
 * Created by Yang on 2017/4/10.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,
 * 3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, pre.length-1, map);
    }
    private TreeNode reConstructBinaryTree(int[] pre, int from1, int to1,
                                           int[] in, int from2, int to2, HashMap<Integer, Integer> map) {
        if(from1 > to1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[from1]);
        int index = map.get(pre[from1]);
        head.left = reConstructBinaryTree(pre, from1+1, from1+index-from2, in, from2, index-1, map);
        head.right = reConstructBinaryTree(pre, from1+index-from2+1, to1, in, index+1, to2, map);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new ReConstructBinaryTree().reConstructBinaryTree(
                new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6}));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString() {
        return "[" + left + "," + val + "," + right + "]";
    }
}
