/**
 * Created by Yang on 2017/4/21.
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 输入例子:
 * 1,2,3,4,5,6,7,0
 * 输出例子:
 * 7
 */
public class InversePairs {
    /**
     * 基于归并排序，边排序边统计逆序对
     * @param array
     * @return
     */
    public int inversePairs(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        int count = inversePairsCore(array, copy, 0, array.length-1);

        return count;
    }

    /**
     * 边归并排序边统计逆序对的数量
     * @param data 原数据
     * @param copy 辅助数组，完成排序后的数据存放在copy中
     * @param from
     * @param to
     * @return data[from...to]中逆序对的数量
     */
    private int inversePairsCore(int[] data, int[] copy, int from, int to) {
        if(from == to) {
            copy[from] = data[from];
            return 0;
        }

        int length = (to - from) / 2;

        // 递归统计左边一半数组中的逆序对
        int left = inversePairsCore(copy, data, from, from+length);
        // 递归统计右边一半数组中的逆序对
        int right = inversePairsCore(copy, data, from+length+1, to);

        int idxToEndOfLeftPart = from + length;
        int idxToEndOfRightPart = to;
        int indexCopy = to;
        int count = 0;
        while(idxToEndOfLeftPart >= from && idxToEndOfRightPart >= from+length+1) {
            if(data[idxToEndOfLeftPart] > data[idxToEndOfRightPart]) {
                //如果左边的数字x大，右边每一个尚未排序的元素（总计sum个）都比x小，共构成sum个逆序数
                copy[indexCopy--] = data[idxToEndOfLeftPart--];
                count += idxToEndOfRightPart - from - length;
                if(count > 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = data[idxToEndOfRightPart--];
            }
        }
        for (; idxToEndOfLeftPart >= from; idxToEndOfLeftPart--) {
            copy[indexCopy--] = data[idxToEndOfLeftPart];
        }
        for (; idxToEndOfRightPart >= from+length+1; idxToEndOfRightPart--) {
            copy[indexCopy--] = data[idxToEndOfRightPart];
        }

        int totalNumOfInversePairs = left + right + count;
        return totalNumOfInversePairs > 1000000007 ? totalNumOfInversePairs % 1000000007 : totalNumOfInversePairs;
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();

        int[] array = new int[]{7,5,6,4};
        System.out.println(inversePairs.inversePairs(array));

        array = new int[]{7,5};
        System.out.println(inversePairs.inversePairs(array));

        array = new int[]{7};
        System.out.println(inversePairs.inversePairs(array));

        array = new int[]{};
        System.out.println(inversePairs.inversePairs(array));

        array = null;
        System.out.println(inversePairs.inversePairs(array));
    }
}
