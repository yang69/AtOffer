import java.util.LinkedList;

/**
 * Created by Yang on 2017/4/23.
 * 圆圈中最后剩下的数字 | 约瑟夫（Josephuse）环
 *
 * 题目：0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。
 * 求出这个圈圈里剩下的最后一个数字。
 *
 * 【法1】：环形链表
 * 【法2】：分析每次被删除的数字的规律
 */
public class LastNumberInCircle {
    /**
     * 【法2】：分析每次被删除的数字的规律
     *      记f(n,m)，表示每次在n个数字0，1，。。。，n-1中每次删除第m个数字最后剩下的数字。
     *      递推公式如下：f(n,m) = [f(n-1,m)+m]%n , (n>1)；n=1时，剩下的数字一定是0
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining2(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    /**
     * 【法1】：
     *      经典的环形链表，每次删除第m个结点，直到剩下最后一个
     *      这里我们可以用LinkedList来模拟环形链表，然后每次走m步，list.remove(idx);
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }

        int idx = 0;
        while(nums.size() > 1) {
            // 每次从idx移动m-1步就能移动到要删除的元素
            for (int i = 0; i < m-1; i++) {
                idx++;
                idx %= nums.size();
            }
            nums.remove(idx);
        }

        return nums.get(0);
    }

    public static void main(String[] args) {
        LastNumberInCircle lastNumberInCircle = new LastNumberInCircle();

        System.out.println(lastNumberInCircle.lastRemaining1(5, 3));
        System.out.println(lastNumberInCircle.lastRemaining2(5, 3));

        System.out.println(lastNumberInCircle.lastRemaining1(0, 0));
        System.out.println(lastNumberInCircle.lastRemaining2(0, 0));

        System.out.println(lastNumberInCircle.lastRemaining1(6, 6));
        System.out.println(lastNumberInCircle.lastRemaining2(6, 6));

        System.out.println(lastNumberInCircle.lastRemaining1(4000, 997));
        System.out.println(lastNumberInCircle.lastRemaining2(4000, 997));
    }
}
