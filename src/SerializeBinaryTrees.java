/**
 * Created by Yang on 2017/4/25.
 * 序列化二叉树：
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 【解】：
 *  通过分析解决前面的第6题 b06_重建二叉树。我们知道可以从前序遍历和中序遍历构造出一棵二叉树。
 *  受此启发，我们可以先把一棵二叉树序列化成一个前序遍历序列和一个中序序列，然后再反序列化时通过这两个序列重构出原二叉树。
 *  【但是】 这个思路有两个缺点。
 *  一个缺点是该方法要求二叉树中不能用有数值重复的结点。
 *  另外只有当两个序列中所有数据都读出后才能开始反序列化。如果两个遍历序列的数据是从一个流里读出来的，那就可能需要等较长的时间。
 *
 *  实际上如果二叉树的序列化是从根结点开始的话，那么相应的反序列化在根结点的数值读出来的时候就可以开始了。
 *  【序列化】：
 *  因此我们可以根据前序遍历的顺序来序列化二叉树，因为前序遍历是从根结点开始的。
 *  当在遍历二叉树碰到 NULL 指针时，这些 NULL 指针序列化成一个特殊的字符（比如‘$’）。
 *                                 另外，结点的数值之间要用一个特殊字符（比如’,’）隔开。
 *  【反序列化】：
 *  按照前序遍历的顺序，来重建二叉树。
 */
public class SerializeBinaryTrees {
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val).append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    TreeNode deserialize(String str) {
        return deserializeCore(str, new int[]{0});
    }

    private TreeNode deserializeCore(String str, int[] index) {
        if(str.charAt(index[0]) == '$') {
            index[0]++;
            return null;
        }
        int value = getValue(str, index);
        TreeNode res = new TreeNode(value);
        index[0]++;
        res.left = deserializeCore(str, index);
        index[0]++;
        res.right = deserializeCore(str, index);
        return res;
    }

    private int getValue(String str, int[] index) {
        int res = 0;
        while(str.charAt(index[0]) <= '9' && str.charAt(index[0]) >= '0') {
            res  = res * 10 + str.charAt(index[0]++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        SerializeBinaryTrees serializeBinaryTrees = new SerializeBinaryTrees();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        String str = serializeBinaryTrees.serialize(root);
        System.out.println(str);
        System.out.println(serializeBinaryTrees.deserialize(str));

        root.left = null;
        str = serializeBinaryTrees.serialize(root);
        System.out.println(str);
        System.out.println(serializeBinaryTrees.deserialize(str));

        root.right.left = null;
        str = serializeBinaryTrees.serialize(root);
        System.out.println(str);
        System.out.println(serializeBinaryTrees.deserialize(str));

        root.right = null;
        str = serializeBinaryTrees.serialize(root);
        System.out.println(str);
        System.out.println(serializeBinaryTrees.deserialize(str));

        root = null;
        str = serializeBinaryTrees.serialize(root);
        System.out.println(str);
        System.out.println(serializeBinaryTrees.deserialize(str));
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
