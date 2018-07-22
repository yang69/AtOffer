/**
 * @author yang
 * @version 0.1 20180720
 * Created by yang on 2017/07/20.
 ************************************************************************************************
 * 在一个二维数组中，每一行都按照
 * 从左到右递增的顺序排序，每一列
 * 都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个
 * 二维数组和一个整数，判断数组中
 * 是否含有该整数。
 ************************************************************************************************
 */
package AtOffer

func Find(target int,  array [][]int) bool {
    if 0 == len(array) {
        return false
    }
    // 从左下角开始查找
    //     1.小于target则向右查找
    //     2.大于target则向上查找
    //     3.找到返回true
    // 出界还没找到就返回false
    i, j := len(array)-1, 0
    for i >= 0 && j <= len(array[0]) {
        n := array[i][j]
        if n == target {
            return true
        } else if n > target {
            i--
        } else {
            // n < target
            j++
        }
    }
    return false
}
