package algo.leetcode;

/**
 * Created by Jun on 2018/7/23.
 */
public class L709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (chars[i]>=65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
