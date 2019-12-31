package algo.leetcode;

/**
 * Created by Jun on 2018/7/10.
 */
public class L344_ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=chars.length-1; i>=0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public String reverseString_better(String s) {
        if (s == null || s == "")
            return s;
        char[] chars = s.toCharArray();
        char temp;
        for (int i=0, j=chars.length-1; i<j; i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
