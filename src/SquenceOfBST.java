/**
 * Created by Yang on 2017/4/17.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class SquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }

        return verifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    private boolean verifySquenceOfBST(int [] sequence, int from, int to) {
        int length = from - to + 1;
        // 后序遍历中，根结点在序列的最后
        int root = sequence[to];

        // 在二叉搜索树中，左子树的结点小于根结点
        int i = from;
        for(; i < to; i++) {
            if(sequence[i] > root)
                break;
        }

        // 在二叉搜索树中，右子树的结点大于根结点
        int j = i;
        for(; j < to; j++) {
            if(sequence[j] < root)
                return false;
        }

        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if(i > from) {
            left = verifySquenceOfBST(sequence, from, i-1);
        }

        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if(i < to) {
            right = verifySquenceOfBST(sequence, from + i, to-1);
        }

        return (left && right);
    }

    public static void main(String[] args) {
        SquenceOfBST squenceOfBST = new SquenceOfBST();
        // true
        System.out.println(squenceOfBST.verifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
        // false
        System.out.println(squenceOfBST.verifySquenceOfBST(new int[]{7,4,6,5}));
        // true
        System.out.println(squenceOfBST.verifySquenceOfBST(new int[]{1}));
        // false
        System.out.println(squenceOfBST.verifySquenceOfBST(new int[]{}));
    }
}
