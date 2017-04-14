/**
 * Created by Yang on 2017/4/14.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * PS：这只青蛙可以随便跳多少级台阶
 */
public class JumpFloorII {
    public int jumpFloorII(int target) {
        return (int)Math.pow(2, target-1);
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++) {
            System.out.println(jumpFloorII.jumpFloorII(i));
        }
        System.out.println("用时：" + (System.currentTimeMillis() - startTime));
    }
}
