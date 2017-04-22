import java.util.ArrayList;

/**
 * Created by Yang on 2017/4/22.
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class TwoNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 2) {
            return res;
        }

        int ahead = array.length - 1;
        int behind = 0;

        while(ahead > behind) {
            int currSum = array[behind] + array[ahead];
            if(currSum == sum) {
                res.add(array[behind]);
                res.add(array[ahead]);
                return res;
            } else if(currSum > sum) {
                ahead--;
            } else {
                behind++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TwoNumbersWithSum twoNumbersWithSum = new TwoNumbersWithSum();

        int[] array = new int[]{1,2,4,7,11,15};
        System.out.println(twoNumbersWithSum.findNumbersWithSum(array, 15));

        array = new int[]{1,2,4,7,11,15};
        System.out.println(twoNumbersWithSum.findNumbersWithSum(array, 10));

        array = new int[]{1,2};
        System.out.println(twoNumbersWithSum.findNumbersWithSum(array, 3));

        array = new int[]{1};
        System.out.println(twoNumbersWithSum.findNumbersWithSum(array, 10));

        array = null;
        System.out.println(twoNumbersWithSum.findNumbersWithSum(array, 10));
    }
}
