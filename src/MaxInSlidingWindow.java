import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yang on 2017/4/25.
 * 滑动窗口的最大值：
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口
 * 有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 【解】：用一个双端队列
 *    队列里存的是数组元素的下标
 *    当前队列头永远放的是当前窗口的最大值；后面的元素依次是，前一个元素滑出窗口后，滑动窗口的最大值
 */
public class MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> maxInWindows = new ArrayList<>();
        if(num.length >= size && size >= 1) {
            Deque<Integer> index = new LinkedList<>();
            // 处理第一个窗口
            for (int i = 0; i < size; i++) {
                // 比新进入滑动窗口的元素小的值都不再可能是滑动窗口的最大值，将这些元素都弹出
                while(!index.isEmpty() && num[i] >= num[index.peekLast()]) {
                    index.pollLast();
                }
                index.offer(i);
            }
            // 滑动窗口，窗口最大值在index的队首
            for (int i = size; i < num.length; i++) {
                maxInWindows.add(num[index.peekFirst()]);
                // 比新进入滑动窗口的元素小的值都不再可能是滑动窗口的最大值，将这些元素都弹出
                while(!index.isEmpty() && num[i] >= num[index.peekLast()]) {
                    index.pollLast();
                }
                // 如果队首元素已经不在当前滑动窗口中，将之弹出
                if(!index.isEmpty() && index.peekFirst() <= (i - size)) {
                    index.pollFirst();
                }

                index.offer(i);
            }
            maxInWindows.add(num[index.peekFirst()]);
        }

        return maxInWindows;
    }

    public static void main(String[] args) {
        MaxInSlidingWindow maxInSlidingWindow = new MaxInSlidingWindow();

        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{6,5,4,3,2,1}, 4));
        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{2,3}, 3));
        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{2,3,4}, 3));
        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 0));
        System.out.println(maxInSlidingWindow.maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 1));
    }
}
