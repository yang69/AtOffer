/**
 * Created by Yang on 2017/4/23.
 * 构建乘积数组：
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class ArrayConstruction {
    public int[] multiply(int[] A) {
        if(A == null || A.length == 0) {
            return new int[0];
        }
        int[] B = new int[A.length];

        // Step 1/2. 求A[0]*A[1]*...*A[i-1]
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }

        // Step 2/2. 求A[i+1]*A[i+2]*...*A[n-1]
        int temp = 1;
        for (int i = A.length-2; i >=0 ; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }

        return B;
    }

    public static void main(String[] args) {
        ArrayConstruction arrayConstruction = new ArrayConstruction();

        int[] A = new int[]{1,2,3,4,5};
        int[] B = arrayConstruction.multiply(A);
        for(int i : B) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
