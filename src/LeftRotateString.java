/**
 * Created by Yang on 2017/4/22.
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串“abcdefg”和数字 2，
 * 该函数将返回左旋转 2 位得到的结果“cdefgab”。
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if(str == null || str.length() < n || n < 0) {
            return str;
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        System.out.println(leftRotateString.leftRotateString("abcdefgh", 2));
    }
}
