import java.util.Arrays;

/**
 * Created by Yang on 2017/4/23.
 * 题目：从扑克牌中随机抽 5 张牌，判断是不是一个顺子， 即这 5 张牌是不是连续的。
 * 2～10 为数字本身， A 为 1。 J 为 11、Q 为 12、 K 为 13。大、小王可以看成任意数字。
 *
 *  【解】：
 *  1. 给这5个数排序，
 *      排序的过程中
 *  2. 统计"0"的个数
 *  3. 统计数组中的空缺总数，
 *      同时还要看是否含有除了'0'以外其他的对子，如果有两张一样的了，则一定不可能是顺子了。！！
 *      如果空缺总数 <= "0"的个数，可以，是连续的！
 *          空缺总数 >  "0"的个数，sorry，连不上！
 */
public class ContinuousCard {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);

        int numOfZero = 0;
        int numOfGap = 0;

        // 统计数组中0的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numOfZero++;
        }

        // 统计数组中的间隔数目
        int small = numOfZero;
        int big = small + 1;
        while(big < numbers.length) {
            // 两个数相等，有对子，不可能是顺子
            if(numbers[small] == numbers[big]) {
                return false;
            }
            numOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }

        return numOfGap > numOfZero ? false : true;
    }

    public static void main(String[] args) {
        ContinuousCard continuousCard = new ContinuousCard();

        System.out.println(continuousCard.isContinuous(new int[]{0,1,3,4,5}));
        System.out.println(continuousCard.isContinuous(new int[]{0,3,3,4,5}));
        System.out.println(continuousCard.isContinuous(new int[]{1,2,3,4,6}));
        System.out.println(continuousCard.isContinuous(new int[]{1,2,3,4,5}));
        System.out.println(continuousCard.isContinuous(new int[]{}));
        System.out.println(continuousCard.isContinuous(null));
    }
}
