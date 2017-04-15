import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/4/15.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组
 * 的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray {
    public void reOrderArray(int[] array) {
        if(array == null || array.length < 2) {
            return;
        }
        Queue<Integer> odds = new LinkedList<>();
        Queue<Integer> evens = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
            if(isEven(array[i])) {
                evens.add(array[i]);
            } else {
                odds.add(array[i]);
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(!odds.isEmpty()) {
                array[i] = odds.poll();
            } else {
                array[i] = evens.poll();
            }
        }
    }

    /**
     * 不保证相对顺序，仅保证奇数在前面
     * @param array
     */
    public void reOrderArray1(int [] array) {
        if(array == null || array.length < 2) {
            return;
        }
        int lo = 0;
        int hi = array.length - 1;
        while(lo < hi) {
            while(lo < hi && !isEven(array[lo])) {
                lo++;
            }
            while(lo < hi && isEven(array[hi])) {
                hi--;
            }
            if(lo < hi) {
                int temp = array[lo];
                array[lo] = array[hi];
                array[hi] = temp;
            }
        }
    }
    private boolean isEven(int n) {
        return (n & 0x1) == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        ReorderArray reorderArray = new ReorderArray();
        reorderArray.reOrderArray(array);
        for(int value : array) {
            System.out.println(value);
        }
    }
}
