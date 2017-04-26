/**
 * Created by Yang on 2017/4/25.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如，
 *      5
 *     / \
 *    3   7
 *  / \  / \
 * 2  4 6  8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 * 【解】：
 *     因为按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的。
 *     所以只需要用中序遍历的方法遍历这棵二叉搜索树，就很容易找出它的第k大结点。
 */
public class KthNodeInBST {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k == 0) {
            return null;
        }
        return KthNodeCore(pRoot, new int[]{k});
    }

    private TreeNode KthNodeCore(TreeNode pRoot, int[] k) {
        TreeNode target = null;
        if(pRoot.left != null) {
            target = KthNodeCore(pRoot.left, k);
        }
        if(target == null) {
            if(k[0] == 1) {
                target = pRoot;
            }
            k[0]--;
        }
        if(target == null && pRoot.right != null) {
            target = KthNodeCore(pRoot.right, k);
        }
        return target;
    }

    public static void main(String[] args) {
        KthNodeInBST kthNodeInBST = new KthNodeInBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        for (int i = 1; i < 8; i++) {
            System.out.println(kthNodeInBST.KthNode(root, i).val + " <--> " + i);
        }
        System.out.println(kthNodeInBST.KthNode(root, 0) + " <--> null");
        System.out.println(kthNodeInBST.KthNode(root, 8) + " <--> null");
        System.out.println(kthNodeInBST.KthNode(null, 1) + " <--> null");
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
