/**
 * Created by Yang on 2017/4/18.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNumber {
    /**
     * 根据数组特点的O(n)的算法
     * 思路：
     * 数组中有一个数字出现的次数超过数组长度的一半，也就是说它
     * 出现的次数比其他所有数字出现次数的和还要多。因此我们可以
     * 考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，
     * 一个是次数。当我们遍历下一个数字的时候，如果下一个数字和
     * 我们之前保存的数字相同，则次数加1；否则减1。如果次数为0，
     * 我们需要保存下一个数字，并把次数设为1。由于我们要找的数字
     * 出现的次数比其他所有数字出现的次数还要多，那么要找的数字
     * 肯定是最后一个把次数设为1时对应的数字。
     * @param array
     * @return
     */
    public int moreThanHalfNum(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(count == 0) {
                result = array[i];
                count = 1;
            }
            if(array[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        // 最后检查一下找到的数字是否出现了一半以上，防止非法输入
        if(isMoreThanHalf(array, result)) {
            return result;
        } else {
            return 0;
        }
    }

    /**
     * 基于Partition函数的O(n)算法
     * 因为这个数字x出现次数超过一半，所以数组的中位数就是x
     * !! 该方法会改变输入数组，慎用
     * @param array
     * @return 出现次数超过一半的数字
     */
    public int moreThanHalfNum1(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int middle = length >> 1; // 用移位运算代替÷2，优化时间效率
        int lo = 0;
        int hi = length - 1;
        int index = partition(array, lo, hi);
        while(index != middle) {
            if(index > middle) {
                hi = index - 1;
                index = partition(array, lo, hi);
            } else {
                lo = index + 1;
                index = partition(array, lo, hi);
            }
        }

        int result = array[middle];
        if(!isMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    private int partition(int[] array, int lo, int hi) {
        if(array == null || array.length == 0 || lo < 0 || hi >= array.length || lo > hi) {
            //TODO 抛出异常
            return -1;
        }
        // 随机选取枢纽元素，避免最坏情况
        int pivotIndex = lo + (int)Math.random() * (hi - lo);
        swap(array, pivotIndex, hi);
        int small = lo - 1;
        for(int i = lo; i < hi; i++) {
            if(array[i] < array[hi]) {
                small++;
                if(small != i) {
                    swap(array, i, small);
                }
            }
        }
        small++;
        swap(array, small, hi);
        return small;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isMoreThanHalf(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == target) {
                count++;
            }
        }
        // 如果target出现次数没有超过一半的话，返回false
        // 用左移运算代替乘以2，可以改善时间效率
        if((count << 1) <= array.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MoreThanHalfNumber moreThanHalfNumber = new MoreThanHalfNumber();

        int [] array = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.print(moreThanHalfNumber.moreThanHalfNum(array) + " ");
        System.out.println(moreThanHalfNumber.moreThanHalfNum1(array));

        array = new int[]{2,1};
        System.out.print(moreThanHalfNumber.moreThanHalfNum(array) + " ");
        System.out.println(moreThanHalfNumber.moreThanHalfNum1(array));

        array = new int[]{2};
        System.out.print(moreThanHalfNumber.moreThanHalfNum(array) + " ");
        System.out.println(moreThanHalfNumber.moreThanHalfNum1(array));

        array = new int[]{};
        System.out.print(moreThanHalfNumber.moreThanHalfNum(array) + " ");
        System.out.println(moreThanHalfNumber.moreThanHalfNum1(array));

        array = null;
        System.out.print(moreThanHalfNumber.moreThanHalfNum(array) + " ");
        System.out.println(moreThanHalfNumber.moreThanHalfNum1(array));
    }
}
