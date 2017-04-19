import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang on 2017/4/18.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class KLeastNumbers {
    /**
     * O(nlogk)的算法，特别适合处理海量数据
     * 基于堆或者红黑树
     * @param array
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers(int[] array, int k) {
        if(array == null || array.length == 0 || k > array.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> kLeastNumbers = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < array.length; i++) {
            if(kLeastNumbers.size() < k) {
                kLeastNumbers.offer(array[i]);
            } else {
                if(kLeastNumbers.peek() > array[i]) {
                    kLeastNumbers.poll();
                    kLeastNumbers.offer(array[i]);
                }
            }
        }
        return new ArrayList<>(kLeastNumbers);
    }

    /**
     * O(n)的算法，只有当我们可以修改输入的数组时可用
     * 基于Partition函数
     * @param array
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers1(int[] array, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length == 0 || k > array.length || k <= 0) {
            return res;
        }
        int lo = 0;
        int hi = array.length - 1;
        int index = partition(array, lo, hi);
        while(index != k-1) {
            if(index > k-1) {
                hi = index - 1;
                index = partition(array, lo, hi);
            } else {
                lo = index + 1;
                index = partition(array, lo, hi);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(array[i]);
        }
        return res;
    }

    private int partition(int[] array, int lo, int hi) {
        if(array == null || array.length == 0 || lo < 0 || hi >= array.length || lo > hi) {
            //TODO 抛出异常
            return -1;
        }
        // 随机选取枢纽元素，避免最坏情况
        int pivotIndex = lo + (int)Math.random() * (hi - lo);
        swap(array, pivotIndex, hi);
        int small = lo - 1;
        for(int i = lo; i < hi; i++) {
            if(array[i] < array[hi]) {
                small++;
                if(small != i) {
                    swap(array, i, small);
                }
            }
        }
        small++;
        swap(array, small, hi);
        return small;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        KLeastNumbers kLeastNumbers = new KLeastNumbers();

        int[] array = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(kLeastNumbers.getLeastNumbers(array, 4));
        System.out.println(kLeastNumbers.getLeastNumbers1(array, 4));

        array = new int[]{4,5,1};
        System.out.println(kLeastNumbers.getLeastNumbers(array, 4));
        System.out.println(kLeastNumbers.getLeastNumbers1(array, 4));

        array = new int[]{4,5,1};
        System.out.println(kLeastNumbers.getLeastNumbers(array, 3));
        System.out.println(kLeastNumbers.getLeastNumbers1(array, 3));

        array = new int[]{};
        System.out.println(kLeastNumbers.getLeastNumbers(array, 4));
        System.out.println(kLeastNumbers.getLeastNumbers1(array, 4));

        array = null;
        System.out.println(kLeastNumbers.getLeastNumbers(array, 4));
        System.out.println(kLeastNumbers.getLeastNumbers1(array, 4));
    }
}
