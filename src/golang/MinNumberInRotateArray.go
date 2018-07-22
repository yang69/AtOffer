/**
 * @author yang
 * @version 0.1 20180721
 * Created by yang on 2017/07/21.
 ************************************************************************************************
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 ************************************************************************************************
 */
package AtOffer

func MinNumberInRotateArray(array []int) int {
	n := len(array)
	if 0 == n {
		return 0
	}

	lo, hi := 0, n-1
	for lo < hi {
		if array[lo] < array[hi] {
			// 左端点值小于右端点值，最小值就是左端点值
			return array[lo]
		}
		mid := lo + (hi-lo)/2
		if array[mid] > array[hi] {
			// 中间值大于右端点值，最小值在右侧
			lo = mid+1
		} else if array[mid] < array[lo] {
			// 中间值小于左端点值，最小值在左侧
			hi = mid
		}
		if array[lo] == array[mid] && array[mid] == array[hi] {
			// 左右两端和中间的数字相等时，无法判断最小数字在左边还是后边，此时只能顺序查找
			return findMinLinear(array[lo:hi])
		}
	}
	return array[lo]
}

func findMinLinear(array []int) int {
	min := array[0]
	for i := 1; i < len(array); i++ {
		min = minimum(min, array[i])
	}
	return min
}

func minimum(a, b int) int {
	if a < b {
		return a
	}
	return b
}
