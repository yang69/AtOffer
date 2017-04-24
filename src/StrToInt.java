/**
 * Created by Yang on 2017/4/23.
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 输入例子:
 * +2147483647
 * 1a33
 * 输出例子:
 * 2147483647
 * 0
 */
public class StrToInt {
    enum Status {
        valid, inValid
    };
    Status gStatus = Status.valid;

    public int strToInt(String str) {
        gStatus = Status.inValid;
        long num = 0L;

        str = str.trim();
        int start = 0;
        if(str != null && str.length() > 0) {
            boolean minus = false;
            char firstChar = str.charAt(0);
            if(firstChar == '+') {
                start = 1;
            } else if(firstChar == '-') {
                start = 1;
                minus = true;
            }

            if(str.length() > start) {
                num = strToIntCore(str, start, str.length(), minus);
            }
        }

        return (int)num;
    }

    private long strToIntCore(String str, int start, int endNotIncluded, boolean minus) {
        long num = 0;

        int flag = minus ? -1 : 1;
        int i = start;
        for (i = start; i < endNotIncluded; i++) {
            char currChar = str.charAt(i);
            if(currChar >= '0' && currChar <= '9') {
                num = num * 10 + flag * (currChar - '0');

                // 溢出
                if((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
                    num = 0;
                    break;
                }
            } else {
                num = 0;
                break;
            }
        }

        if(i == endNotIncluded) {
            gStatus = Status.valid;
        }

        return num;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();

        System.out.println(strToInt.strToInt("123456"));
        System.out.println(strToInt.strToInt("+123456"));
        System.out.println(strToInt.strToInt("-123456"));
        System.out.println(strToInt.strToInt("12345678900"));
        System.out.println(strToInt.strToInt("0"));
    }
}
