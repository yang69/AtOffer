import java.util.Arrays;

/**
 * Created by Yang on 2017/4/25.
 * 字符流中第一个不重复的字符
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstNotRepeatingCharInStream {
    // occurrence[i]: A character with ASCII value i;
    // occurrence[i] = -1: The character has not found;
    // occurrence[i] = -2: The character has been found for mutlple times
    // occurrence[i] >= 0: The character has been found only once
    private int[] occurrence;
    private int index;

    public FirstNotRepeatingCharInStream() {
        occurrence = new int[256];
        Arrays.fill(occurrence, -1);
        index = 0;
    }

    //Insert one char from stringstream
    public void insert(char ch)
    {
        if(occurrence[ch] == -1) {
            occurrence[ch] = index;
        } else if(occurrence[ch] >= 0) {
            occurrence[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
        char firstAppearingOnceCh = '#';
        int firstAppearingOnceChIndex = Integer.MAX_VALUE;
        for (int i = 0; i < occurrence.length; i++) {
            if(occurrence[i] >= 0 && occurrence[i] < firstAppearingOnceChIndex) {
                firstAppearingOnceCh = (char)i;
                firstAppearingOnceChIndex = occurrence[i];
            }
        }
        return firstAppearingOnceCh;
    }

    public static void main(String[] args) {
        FirstNotRepeatingCharInStream firstNotRepeatingCharInStream = new FirstNotRepeatingCharInStream();
        String s = "google";
        for (int i = 0; i < s.length(); i++) {
            firstNotRepeatingCharInStream.insert(s.charAt(i));
        }
        System.out.println(firstNotRepeatingCharInStream.firstAppearingOnce() == 'l');

        s = "lgooglee";
        for (int i = 0; i < s.length(); i++) {
            firstNotRepeatingCharInStream.insert(s.charAt(i));
        }
        System.out.println(firstNotRepeatingCharInStream.firstAppearingOnce() == '#');
    }
}
