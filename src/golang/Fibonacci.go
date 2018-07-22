/**
 * @author yang
 * @version 0.1 20180721
 * Created by yang on 2017/07/21.
 ************************************************************************************************
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 ************************************************************************************************
 */
package AtOffer

/**
 * 用以下公式将斐波纳契数列问题转换成矩阵的乘方，并用递归求解矩阵的乘方
 * [[f(n),f(n-1)],[f(n-1),f(n-2)]] = [[1,1],[1,0]]^(n-1)
 */
func Fibonacci(n int) int {
	if 0 == n {
		return 0
	}
	if 1 == n {
		return 1
	}
	matrix := [2][2]int{{1,1},{1,0}}
	result := matrixNthPow(matrix, n-1)
	return result[0][0]
}

func matrixNthPow(matrix [2][2]int, n int) [2][2]int {
	if 1 == n {
		return matrix
	}
	if 0 == (n & 1) {
		half := matrixNthPow(matrix, n >> 1)
		return matrixMultiple(half, half)
	}
	return matrixMultiple(matrix, matrixNthPow(matrix, n-1))
}

func matrixMultiple(A, B [2][2]int) [2][2]int {
	return [2][2]int{
		{A[0][0]*B[0][0]+A[0][1]*B[1][0], A[0][0]*B[1][0]+A[0][1]*B[1][1]},
		{A[1][0]*B[0][0]+A[1][1]*B[1][0], A[1][0]*B[1][0]+A[1][1]*B[1][1]},
	}
}
