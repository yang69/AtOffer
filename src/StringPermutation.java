import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yang on 2017/4/18.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StringPermutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        permutation(res, chars, 0);
        Collections.sort(res);
        return res;
    }

    private void permutation(ArrayList<String> res, char[] chars, int begin) {
        if(begin == chars.length) {
            res.add(new String(chars));
        }
        for(int i = begin; i < chars.length; i++) {
            // 每次将begin后的一个字符chars[i]与chars[begin]交换，需避免重复
            // 因为每一个i左侧的字符都曾被交换到begin的位置上，因此只要chars[i]
            // 没有在[begin,i)上出现过，就可以被交换到begin的位置上；
            // 否则，chars[i]是重复的，不需要交换
            if(isDuplicate(chars, begin, i)) {
                continue;
            } else {
                swap(chars, begin, i);
                permutation(res, chars, begin+1);
                swap(chars, begin, i);
            }
        }
    }

    private boolean isDuplicate(char[] chars, int begin, int index) {
        for(int i = begin; i < index; i++) {
            if(chars[index] == chars[i]) {
                return true;
            }
        }
        return false;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();

        String str = "1234";
        ArrayList<String> perms = stringPermutation.permutation(str);
        System.out.println(perms.size() + "" + perms);

        str = "1112";
        perms = stringPermutation.permutation(str);
        System.out.println(perms.size() + "" + perms);

        str = "1";
        perms = stringPermutation.permutation(str);
        System.out.println(perms.size() + "" + perms);

        str = "";
        perms = stringPermutation.permutation(str);
        System.out.println(perms.size() + "" + perms);

        str = null;
        perms = stringPermutation.permutation(str);
        System.out.println(perms.size() + "" + perms);
    }
}
