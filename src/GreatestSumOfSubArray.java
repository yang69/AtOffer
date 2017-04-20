/**
 * Created by Yang on 2017/4/20.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class GreatestSumOfSubArray {
    /**
     * 动态规划
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }

        int currSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(currSum <= 0) {
                currSum = array[i];
            } else {
                currSum += array[i];
            }

            if(currSum > greatestSum) {
                greatestSum = currSum;
            }
        }

        return greatestSum;
    }

    public static void main(String[] args) {
        GreatestSumOfSubArray greatestSumOfSubArray = new GreatestSumOfSubArray();

        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(greatestSumOfSubArray.findGreatestSumOfSubArray(array));

        array = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(greatestSumOfSubArray.findGreatestSumOfSubArray(array));

        array = new int[]{6};
        System.out.println(greatestSumOfSubArray.findGreatestSumOfSubArray(array));

        array = new int[]{};
        System.out.println(greatestSumOfSubArray.findGreatestSumOfSubArray(array));

        array = null;
        System.out.println(greatestSumOfSubArray.findGreatestSumOfSubArray(array));
    }
}
