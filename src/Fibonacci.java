/**
 * Created by Yang on 2017/4/14.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Fibonacci {
    /**
     * 用循环代替递归实现斐波纳契数列，因为递归会重复计算中间值，递归的复杂度实际上是指数的
     * @param n
     * @return 斐波纳契数列的第n项
     */
    public int fibonacci(int n) {
        int[] result = new int[]{0,1};
        if(n < 2) {
            return result[n];
        }
        int fibonacciNthMinusTwo = result[0];
        int fibonacciNthMinusOne = result[1];
        int fibonacciNth = 1;
        for(int i = 2; i <= n; i++) {
            fibonacciNth = fibonacciNthMinusOne + fibonacciNthMinusTwo;

            fibonacciNthMinusTwo = fibonacciNthMinusOne;
            fibonacciNthMinusOne = fibonacciNth;
        }
        return fibonacciNth;
    }

    /**
     * 用以下公式将斐波纳契数列问题转换成矩阵的乘方，并用递归求解矩阵的乘方
     * [[f(n),f(n-1)],[f(n-1),f(n-2)]] = [[1,1],[1,0]]^(n-1)
     * @param n
     * @return 斐波纳契数列的第n项
     */
    public int fibonacci2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[][] matrix = new int[][]{{1,1},{1,0}};
        int[][] res = matrixNthPow(matrix, n-1);
        return res[0][0];
    }
    private int[][] matrixNthPow(int[][] matrix, int n) {
        if(n == 1) return matrix;
        if(n % 2 != 0) {
            return matrixMultiple(matrix, matrixNthPow(matrix, n-1));
        } else {
            int[][] halfNthPow = matrixNthPow(matrix, n/2);
            return matrixMultiple(halfNthPow, halfNthPow);
        }
    }
    private int[][] matrixMultiple(int[][] A, int[][] B) {
        return new int[][]{{A[0][0]*B[0][0] + A[0][1]*B[1][0], A[0][0]*B[0][1] + A[0][1]*B[1][1]},
                {A[1][0]*B[0][0] + A[1][1]*B[1][0], A[1][0]*B[0][1] + A[1][1]*B[1][1]}};
    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
//        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++) {
            System.out.println(fibonacci.fibonacci(i));
        }
//        System.out.println(System.currentTimeMillis() - startTime);
    }
}
