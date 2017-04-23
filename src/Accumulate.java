/**
 * Created by Yang on 2017/4/23.
 * 题目：求1 + 2 + ···+ n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B : C）
 */
public class Accumulate {
    private static class Temp {
        private static int n;
        private static int sum;

        public Temp() {
            ++n;
            sum += n;
        }

        public static void reset() {
            n = 0;
            sum = 0;
        }

        public static int getSum() {
            return sum;
        }
    }

    /**
     * 利用构造函数求解
     * 调用n次构造函数，在构造函数中求sum
     * @param n
     * @return
     */
    public int sum_Solution(int n) {
        Temp[] temps = new Temp[n];
        Temp.reset();
        for (int i = 0; i < temps.length; i++) {
            temps[i] = new Temp();
        }

        return Temp.getSum();
    }

    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();

        System.out.println(accumulate.sum_Solution(10));
        System.out.println(accumulate.sum_Solution(100));
        System.out.println(accumulate.sum_Solution(1000));
    }
}
