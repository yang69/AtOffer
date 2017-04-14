/**
 * Created by Yang on 2017/4/14.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        int wayToNthMinusTwoFloor = 1;
        int wayToNthMinusOneFloor = 1;
        int wayToNthFloor = 1;
        for(int i = 2; i <= target; i++) {
            wayToNthFloor = wayToNthMinusOneFloor + wayToNthMinusTwoFloor;

            wayToNthMinusTwoFloor = wayToNthMinusOneFloor;
            wayToNthMinusOneFloor = wayToNthFloor;
        }
        return wayToNthFloor;
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 12; i++) {
            System.out.println(jumpFloor.jumpFloor(i));
        }
        System.out.println("用时：" + (System.currentTimeMillis() - startTime));
    }
}
