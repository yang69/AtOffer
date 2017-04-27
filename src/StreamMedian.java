import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang on 2017/4/25.
 * 数据流中的中位数：
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数
 * 个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class StreamMedian {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void insert(Integer num) {
        if(((min.size() + max.size()) & 0x1) == 0) {
            if(max.size() > 0 && num < max.peek()) {
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        } else {
            if(min.size() > 0 && num > min.peek()) {
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double getMedian() {
        int size = min.size() + max.size();
        if(size == 0) {
            throw new RuntimeException("没有这样的数");
        }

        double median = 0;
        if((size & 0x1) == 1) {
            median = min.peek();
        } else {
            median = min.peek()/2.0 + max.peek()/2.0;
        }

        return median;
    }

    public static void main(String[] args) {
        StreamMedian streamMedian = new StreamMedian();

        for (int i = 0; i < 250.41; i++) {
            streamMedian.insert(i);
        }
        System.out.println(streamMedian.getMedian());
    }
}
