/**
 * Created by Yang on 2017/4/23.
 * 正则表达式匹配：
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有
 * 字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和
 * "ab*a"均不匹配
 */
public class RegularExpressionsMatching {
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strStart, char[] pattern, int patternStart) {
        if(strStart == str.length && patternStart == pattern.length) {
            return true;
        }

        if(strStart != str.length && patternStart == pattern.length) {
            return false;
        }

        if(patternStart + 1 < pattern.length && pattern[patternStart+1] == '*') {
            if((strStart < str.length && pattern[patternStart] == str[strStart])
                    || (pattern[patternStart] == '.' && strStart <= str.length)) {
                        // 匹配当前字符
                return matchCore(str, strStart+1, pattern, patternStart+2)
                        // 跳过字符串的当前字符
                        || matchCore(str, strStart+1, pattern, patternStart)
                        // 跳过模式的当前"某*"字串
                        || matchCore(str, strStart, pattern, patternStart+2);
            } else {
                return matchCore(str, strStart, pattern, patternStart+2);
            }
        }

        if((strStart < str.length && str[strStart] == pattern[patternStart])
                || (pattern[patternStart] == '.' && strStart < str.length)) {
            return matchCore(str, strStart+1, pattern, patternStart+1);
        }

        return false;
    }

    public static void main(String[] args) {
        RegularExpressionsMatching regularExpressionsMatching = new RegularExpressionsMatching();

        System.out.println(regularExpressionsMatching.match("aaa".toCharArray(), "a.a".toCharArray()));
        System.out.println(regularExpressionsMatching.match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(regularExpressionsMatching.match("aaa".toCharArray(), "aa.a".toCharArray()));
        System.out.println(regularExpressionsMatching.match("aaa".toCharArray(), "ab*a".toCharArray()));
        System.out.println(regularExpressionsMatching.match("".toCharArray(), ".*".toCharArray()));
        System.out.println(regularExpressionsMatching.match("".toCharArray(), "c*".toCharArray()));
    }
}
