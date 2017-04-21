/**
 * Created by Yang on 2017/4/21.
 * 在一个字符串(1<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置。如果字符串为空,返回-1
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) {
            return -1;
        }

        final int tableSize = 256;
        int[] hashTable = new int[tableSize];
        for (char c : str.toCharArray()) {
            hashTable[c]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if(hashTable[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();

        // 1
        System.out.println(firstNotRepeatingChar.firstNotRepeatingChar("abaccdeff"));
        // 4
        System.out.println(firstNotRepeatingChar.firstNotRepeatingChar("google"));
        // -1
        System.out.println(firstNotRepeatingChar.firstNotRepeatingChar(""));
        // -1
        System.out.println(firstNotRepeatingChar.firstNotRepeatingChar(null));
    }
}
