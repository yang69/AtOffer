/**
 * Created by Yang on 2017/4/22.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class NumbersAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2) {
            return;
        }

        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }

        int indexOf1 = findFirstBitIs1(resultExclusiveOR);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if(isBit1(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirstBitIs1(int num) {
        int indexBit = 0;
        while(((num & 1) == 0) && (indexBit < 32)) {
            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    private boolean isBit1(int num, int indexBit) {
        num >>= indexBit;
        return (num & 1) != 0;
    }

    public static void main(String[] args) {
        NumbersAppearOnce numbersAppearOnce = new NumbersAppearOnce();

        int[] array = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        numbersAppearOnce.findNumsAppearOnce(array, num1, num2);
        System.out.printf("%d,%d.%n", num1[0], num2[0]);

        array = new int[]{2,4};
        num1 = new int[1];
        num2 = new int[1];
        numbersAppearOnce.findNumsAppearOnce(array, num1, num2);
        System.out.printf("%d,%d.%n", num1[0], num2[0]);

        array = new int[]{2};
        num1 = new int[1];
        num2 = new int[1];
        numbersAppearOnce.findNumsAppearOnce(array, num1, num2);
        System.out.printf("%d,%d.%n", num1[0], num2[0]);

        array = new int[]{};
        num1 = new int[1];
        num2 = new int[1];
        numbersAppearOnce.findNumsAppearOnce(array, num1, num2);
        System.out.printf("%d,%d.%n", num1[0], num2[0]);

        array = null;
        num1 = new int[1];
        num2 = new int[1];
        numbersAppearOnce.findNumsAppearOnce(array, num1, num2);
        System.out.printf("%d,%d.%n", num1[0], num2[0]);
    }
}
