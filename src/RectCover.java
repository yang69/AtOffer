/**
 * Created by Yang on 2017/4/14.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int rectCover(int target) {
        int minusTwo = 1;
        int minusOne = 2;
        int res = 3;
        if(target == 0) return 0;
        if(target == 1) return minusTwo;
        if(target == 2) return minusOne;
        for(int i = 3; i <= target; i++) {
            res = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = res;
        }
        return res;
    }

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++) {
            System.out.println(rectCover.rectCover(i));
        }
        System.out.println("用时：" + (System.currentTimeMillis() - startTime));
    }
}
