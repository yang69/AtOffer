/**
 * Created by Yang on 2017/4/20.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1 {
    /**
     * 从数字规律着手提升时间效率
     * 时间复杂度O(logn)
     * @param n
     * @return
     */
    public int numberOf1Between1AndN(int n) {
        if(n <= 0) {
            return 0;
        }

        return numberOf1Between1AndN(n+"");
    }

    private int numberOf1Between1AndN(String strN) {
        if(strN == null || strN.length() == 0 || strN.charAt(0) > '9' || strN.charAt(0) < '0') {
            return 0;
        }

        int firstDigit = strN.charAt(0) - '0'; //最高位
        int length = strN.length();

        if(length == 1 && firstDigit == 0) {
            return 0;
        }
        if(length == 1 && firstDigit != 0) {
            return 1;
        }

        // 假设数字是“21345”
        // 1.numOf1InFirstDigit是最高位中1的个数，即10000 ~ 19999 第一位中1的个数（个位、十位、百位、千位的1不算在内）
        int numOf1InFirstDigit = 0;
        if(firstDigit > 1) {
            numOf1InFirstDigit = powerBase10(length - 1);
        } else if(firstDigit == 1) {
            numOf1InFirstDigit = Integer.parseInt(strN.substring(1,length)) + 1;
        }

        // 2.numOf1InOtherDigits是非最高位中1的个数，即1346 ~ 21345 除了第一位中的1的个数（万位的1不算在内）
        int numOf1InOtherDigits = firstDigit * (length - 1) * powerBase10(length - 2);

        // 3.numOf1InRecursive是1 ~ 1345中1的个数（各个位的都算）
        int numOf1InRecursive = numberOf1Between1AndN(strN.substring(1, length));

        return numOf1InFirstDigit + numOf1InOtherDigits + numOf1InRecursive;
    }

    private int powerBase10(int n) {
        if(n < 0) {
            throw new RuntimeException("只能计算10的非负整数次幂");
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }

        return res;
    }

    public int numberOf1Between1AndN1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for(char c : (i + "").toCharArray()) {
                if(c == '1')
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.print(numberOf1.numberOf1Between1AndN(21345) + ",");
        System.out.println(numberOf1.numberOf1Between1AndN1(21345));
        System.out.print(numberOf1.numberOf1Between1AndN(10) + ",");
        System.out.println(numberOf1.numberOf1Between1AndN1(10));
        System.out.print(numberOf1.numberOf1Between1AndN(-100) + ",");
        System.out.println(numberOf1.numberOf1Between1AndN1(-100));
        System.out.print(numberOf1.numberOf1Between1AndN(0) + ",");
        System.out.println(numberOf1.numberOf1Between1AndN1(0));
        System.out.print(numberOf1.numberOf1Between1AndN(1) + ",");
        System.out.println(numberOf1.numberOf1Between1AndN1(1));
    }
}
