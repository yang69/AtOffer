import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yang on 2017/4/21.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SortArrayForMinNumber {
    public String printMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        if(numbers.length == 1) {
            return numbers[0] + "";
        }

        String[] numberStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = numbers[i] + "";
        }

        Arrays.sort(numberStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return o1o2.compareTo(o2o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberStrings.length; i++) {
            sb.append(numberStrings[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SortArrayForMinNumber sortArrayForMinNumber = new SortArrayForMinNumber();

        int[] numbers = new int[]{3,32,321};
        System.out.println(sortArrayForMinNumber.printMinNumber(numbers));

        numbers = new int[]{3};
        System.out.println(sortArrayForMinNumber.printMinNumber(numbers));

        numbers = new int[]{};
        System.out.println(sortArrayForMinNumber.printMinNumber(numbers));

        numbers = null;
        System.out.println(sortArrayForMinNumber.printMinNumber(numbers));
    }
}
