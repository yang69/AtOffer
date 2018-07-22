/**
 * @author yang
 * @version 0.1 20180722
 * Created by yang on 2017/07/22.
 ************************************************************************************************
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 ************************************************************************************************
 */
package AtOffer

func RectCover(n int) int {
	if 0 == n {
		return 0
	}
	if 1 == n {
		return 1
	}
	minusTwo, minusOne, res := 1, 2, 2
	for i:= 2; i < n; i++ {
		res = minusOne + minusTwo
		minusTwo = minusOne
		minusOne = res
	}
	return res
}
