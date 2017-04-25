/**
 * Created by Yang on 2017/4/23.
 * 表示数值的字符串：
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是
 * "12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class NumericStrings {
    /**
     * 数值的格式可以表示为I1.U1[e|E]I2
     * 其中，I1、I2是整数，U1是无符号整数
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        int index = 0;
        if(str[index] == '+' || str[index] == '-') {
            index++;
        }
        // 只有“+/-”，不是数值
        if(index >= str.length) {
            return false;
        }
        index = scanDigits(str, index);
        // 已经到结尾了，没有小数和指数部分
        if(index >= str.length) {
            return true;
        }
        if(str[index] == '.') {
            index++;
        }
        index = scanDigits(str, index);
        // 已经到结尾了，没有指数部分
        if(index >= str.length) {
            return true;
        }
        if(str[index] == 'e' || str[index] == 'E') { // 判断指数部分
            index++;
            // “e|E”后没有内容，不是数值
            if(index >= str.length) {
                return false;
            }
            if(str[index] == '+' || str[index] == '-') {
                index++;
            }
            // “e|E”后只有“+/-”，不是数值
            if(index >= str.length) {
                return false;
            }
            index = scanDigits(str, index);
            // 数值 + e|E + 数值
            if(index >= str.length) {
                return true;
            }
        }
        return false;
    }

    private int scanDigits(char[] str, int index) {
        while(index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        NumericStrings numericStrings = new NumericStrings();

        System.out.println(numericStrings.isNumeric("+100".toCharArray()));
        System.out.println(numericStrings.isNumeric("5e2".toCharArray()));
        System.out.println(numericStrings.isNumeric("-123".toCharArray()));
        System.out.println(numericStrings.isNumeric("3.1416".toCharArray()));
        System.out.println(numericStrings.isNumeric("-1E-16".toCharArray()));
        System.out.println();
        System.out.println(numericStrings.isNumeric("12e".toCharArray()));
        System.out.println(numericStrings.isNumeric("1a3.14".toCharArray()));
        System.out.println(numericStrings.isNumeric("1.2.3".toCharArray()));
        System.out.println(numericStrings.isNumeric("+-5".toCharArray()));
        System.out.println(numericStrings.isNumeric("12e+4.3".toCharArray()));
        System.out.println();
        System.out.println(numericStrings.isNumeric("-.123".toCharArray()));
        System.out.println(numericStrings.isNumeric("-1.".toCharArray()));
        System.out.println();
        System.out.println(numericStrings.isNumeric("1+23".toCharArray()));
    }
}
