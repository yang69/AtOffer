/**
 * Created by Yang on 2017/4/23.
 * 翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 */
public class ReverseWordsInSentence {
    public String reverseSentence(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }
        if(str.trim().length() == 0) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i > 0 ; i--) {
            sb.append(words[i]).append(" ");
        }
        if(words.length > 0) {
            sb.append(words[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();

        System.out.println(reverseWordsInSentence.reverseSentence("I am a student."));
        System.out.println(reverseWordsInSentence.reverseSentence("I"));
        System.out.println(reverseWordsInSentence.reverseSentence("  "));
        System.out.println(reverseWordsInSentence.reverseSentence(""));
        System.out.println(reverseWordsInSentence.reverseSentence(null));
    }
}
