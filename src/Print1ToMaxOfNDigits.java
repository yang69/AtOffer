/**
 * Created by Yang on 2017/4/15.
 * 打印1到最大的n位数：
 *
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3，……，一直到最大的3位数即999
 */
public class Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if(n <= 0) return;

        int size = (n+7)/8;
        int[] number = new int[size]; //每个int存储8位十进制数

        // 每8位十进制存入一个int中，不足8位的部分存在最开头的一个int里
        int prefixDigits = (n & 0x7); // n % 8。按8位一组，分组后多余的位数
        if(prefixDigits == 0) {
            print1ToMaxOfNDigitsRecursively(number, 0);
        } else {
            int prefixMax = (int)Math.pow(10, prefixDigits);
            for(int i = 0; i < prefixMax; i++) {
                number[0] = i;
                print1ToMaxOfNDigitsRecursively(number, 1);
            }
        }
    }

    public void print1ToMaxOfNDigitsRecursively(int[] number, int index) {
        if(index == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 100000000; i++) {
            number[index] = i;
            print1ToMaxOfNDigitsRecursively(number, index+1);
        }
    }

    private void printNumber(int[] number) {
        boolean isBeginningZero = true;
        for (int i = 0; i < number.length; i++) {
            if(isBeginningZero && number[i] != 0) {
                isBeginningZero = false;
            }
            if(!isBeginningZero) {
                System.out.print(number[i]);
            }
        }
        if(!isBeginningZero) {
            System.out.println();
        }
    }

    // 测试了1到11位，都没有问题
    public static void main(String[] args) {
        Print1ToMaxOfNDigits print1ToMaxOfNDigits = new Print1ToMaxOfNDigits();

        if(args.length == 1) {
            print1ToMaxOfNDigits.print1ToMaxOfNDigits(Integer.parseInt(args[0]));
        }
        print1ToMaxOfNDigits.print1ToMaxOfNDigits(3);
    }
}
