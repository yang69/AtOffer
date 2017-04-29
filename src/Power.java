/**
 * Created by Yang on 2017/4/14.
 * 数值的整数次方：
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * PS：用右移运算替代除以2，用位与0x01运算代替对2取余
 */
public class Power {
    /**
     * 0的负指数次幂无意义
     * 0的0次幂无意义
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public double power(double base, int exponent) {
        if(equal(base, 0.0) && exponent <= 0) {
            throw new ArithmeticException("0的负指数次幂无意义，0的0次幂无意义");
        }
        if(exponent < 0)
            return 1.0 / powerWithUnsignedExponent(base, -exponent);
        else
            return powerWithUnsignedExponent(base, exponent);
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1) // exponent是奇数
            result *= base;
        return result;
    }

    private boolean equal(double d1, double d2) {
        if((d1 - d2) < 0.0000001
                && (d1 - d2) > -0.0000001) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power(2.0, 2) + " <--> 4.0");
        System.out.println(power.power(2.0, -2) + " <--> 0.25");
        System.out.println(power.power(2.0, 0) + " <--> 1.0");
        System.out.println(power.power(0, 2) + " <--> 0.0");
//        System.out.println(power.power(0, 0) + " <--> Exception in thread \"main\" java.lang.ArithmeticException: 0的负指数次幂无意义，0的0次幂无意义");
    }
}
