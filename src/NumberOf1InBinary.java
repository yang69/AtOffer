/**
 * Created by Yang on 2017/4/14.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1InBinary {
    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1InBinary numberOf1 = new NumberOf1InBinary();
        System.out.println(numberOf1.numberOf1(1));
        System.out.println(numberOf1.numberOf1(0x7FFFFFFF));
        System.out.println(numberOf1.numberOf1(0x80000000));
        System.out.println(numberOf1.numberOf1(0xFFFFFFFF));
    }
}
