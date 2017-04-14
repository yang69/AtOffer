/**
 * Created by Yang on 2017/4/10.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        if(array[0] < array[array.length-1]) {//此时数组没有旋转，整体有序，最左侧的数字最小
            return array[0];
        }
        int lo = 0;
        int hi = array.length - 1;
        while(hi - lo > 1) {
            int mid = lo + (hi-lo)/2;
            if(array[lo] == array[mid] && array[mid] == array[hi]) {
                //左右两端和中间的数字相等时，无法判断最小数字在左边还是后边，此时只能顺序查找
                return findMinInOrder(array, lo, hi);
            }
            if(array[mid] >= array[lo]) {
                lo = mid;
            } else if(array[mid] <= array[hi]) {
                hi = mid;
            }
        }
        return array[hi];
    }

    private int findMinInOrder(int[] array, int from, int to) {
        int min = array[from];
        for(int i = from+1; i <= to; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //输出应为0
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(new int[]{1,0,1,1,1}));
        //输出应为0
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(new int[]{1,1,1,0,1}));
        //输出应为1
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(new int[]{3,4,5,1,2}));
        //输出应为154
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335}));
    }
}
