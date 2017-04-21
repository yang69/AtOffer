/**
 * Created by Yang on 2017/4/21.
 * 把只包含素因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    /**
     * 每一个丑数都是由前面的丑数乘以2、3或5得到的
     * @param index
     * @return 第index个丑数
     */
    public int getUglyNumber(int index) {
        if(index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int multiply2index = 0;
        int multiply3index = 0;
        int multiply5index = 0;
        while(nextUglyIndex < index) {
            int min = min(uglyNumbers[multiply2index] * 2, uglyNumbers[multiply3index] * 3, uglyNumbers[multiply5index] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while(uglyNumbers[multiply2index]*2 <= uglyNumbers[nextUglyIndex]) {
                multiply2index++;
            }
            while(uglyNumbers[multiply3index]*3 <= uglyNumbers[nextUglyIndex]) {
                multiply3index++;
            }
            while(uglyNumbers[multiply5index]*5 <= uglyNumbers[nextUglyIndex]) {
                multiply5index++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex-1];
    }

    private int min(int v1, int v2, int v3) {
        int m1 = v1 < v2 ? v1 : v2;
        return m1 < v3 ? m1 : v3;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();

        for (int i = 0; i < 50; i++) {
            System.out.print(uglyNumber.getUglyNumber(i) + "\t");
        }
    }
}
