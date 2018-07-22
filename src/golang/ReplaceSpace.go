/**
 * @author yang
 * @version 0.1 20180720
 * Created by yang on 2017/07/20.
 ************************************************************************************************
 * 替换空格
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 ************************************************************************************************
 */
package AtOffer

func ReplaceSpace(str string) string {
	if 0 == len(str) {
		return str
	}
	numOfSpaces := countSpace(str)
	finalLength := len(str) + 2*numOfSpaces
	var resultString = make([]rune, finalLength)
	j := 0
	for _,r := range str {
		if ' ' == r {
			resultString[j] = '%'; j++
			resultString[j] = '2'; j++
			resultString[j] = '0'; j++
		} else {
			resultString[j] = r; j++
		}
	}

	return string(resultString)
}

func countSpace(str string) int {
	num := 0

	for _,r := range str {
		if ' ' == r {
			num++
		}
	}

	return num
}
