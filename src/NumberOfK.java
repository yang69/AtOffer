/**
 * Created by Yang on 2017/4/22.
 * 统计一个数字在排序数组中出现的次数。
 */
public class NumberOfK {
    public int getNumberOfK(int [] array , int k) {
        int number = 0;

        if(array != null && array.length > 0) {
            int first = getFirstK(array, k, 0, array.length-1);
            int last = getLastK(array, k, 0, array.length-1);

            if(first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if(start > end) {
            return -1;
        }

        int middleIndex = start + (end - start)/2;
        int middleData = array[middleIndex];
        if(middleData == k) {
            if((middleIndex > 0 && array[middleIndex-1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if(middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if(start > end) {
            return -1;
        }

        int middleIndex = start + (end - start)/2;
        int middleData = array[middleIndex];
        if(middleData == k) {
            if((middleIndex < array.length-1 && array[middleIndex+1] != k) || middleIndex == array.length-1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if(middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        NumberOfK numberOfK = new NumberOfK();

        System.out.println(numberOfK.getNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3));
        System.out.println(numberOfK.getNumberOfK(new int[]{3}, 3));
        System.out.println(numberOfK.getNumberOfK(new int[]{3}, 1));
        System.out.println(numberOfK.getNumberOfK(new int[]{}, 1));
        System.out.println(numberOfK.getNumberOfK(null, 1));
    }
}
