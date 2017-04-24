/**
 * Created by Yang on 2017/4/23.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddTwoNumbers {
    public int add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        System.out.println(addTwoNumbers.add(23, 75)); // 98
        System.out.println(addTwoNumbers.add(-23, 75)); // 52
        System.out.println(addTwoNumbers.add(0, 75)); // 75
        System.out.println(addTwoNumbers.add(23, 0)); // 23
        System.out.println(addTwoNumbers.add(0, 0)); // 0
    }
}
