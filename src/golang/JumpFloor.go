/**
 * @author yang
 * @version 0.1 20180722
 * Created by yang on 2017/07/22.
 ************************************************************************************************
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 ************************************************************************************************
 */
package AtOffer

func JumpFloor(n int) int {
	if 0 == n {
		return 0
	}
	if 1 == n {
		return 1
	}
	wayToNthFloor, wayToNthMinusOneFloor, wayToNthMinusTwoFloor := 1, 1, 1
	for i := 1; i < n; i++ {
		wayToNthFloor = wayToNthMinusOneFloor + wayToNthMinusTwoFloor
		wayToNthMinusTwoFloor = wayToNthMinusOneFloor
		wayToNthMinusOneFloor = wayToNthFloor
	}

	return wayToNthFloor
}
