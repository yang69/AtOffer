/**
 * @author yang
 * @version 0.1 20180722
 * Created by yang on 2017/07/22.
 ************************************************************************************************
 * 数值的整数次方：
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * PS：用右移运算替代除以2，用位与0x01运算代替对2取余
 ************************************************************************************************
 */
package AtOffer

import "errors"

func Power(base float64, exponent int) (float64, error) {
	if floatEqual(base, 0.0) && exponent <= 0 {
		return 0, errors.New("illegal argument")
	}
	if exponent < 0 {
		return 1.0/powerWithUnsignedExponent(base, -exponent), nil
	}
	return powerWithUnsignedExponent(base, exponent), nil
}

func powerWithUnsignedExponent(base float64, exponent int) float64 {
	if 0 == exponent {
		return 1.0
	}
	if 1 == exponent {
		return base
	}

	result := powerWithUnsignedExponent(base, exponent >> 1)
	result = result * result
	if 0 != (exponent & 1) {
		// exponent是奇数
		result *= base
	}

	return result
}

func floatEqual(a, b float64) bool {
	precision := 1e-8
	if a > b {
		return a - b < precision
	} else {
		return b -a < precision
	}
}
