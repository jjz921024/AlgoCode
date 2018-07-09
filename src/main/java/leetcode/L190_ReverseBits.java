package leetcode;

/**
 * Created by Jun on 2018/7/9.
 */
public class L190_ReverseBits {
    public int reverseBits(int n) {
        char[] chars = Integer.toString(n, 2).toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = c;
        }
        return Integer.parseInt(new String(chars));
    }

}
