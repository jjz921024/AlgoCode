package leetcode;

/**
 * Created by Jun on 2018/7/10.
 */
public class L125_ValidPalindrome__ {
    public boolean isPalindrome(String s) {
        if (s == null || s == "")
            return true;

        char[] chars = s.toLowerCase().toCharArray();
        for (int i=0, j=chars.length-1; i<j; i++, j--) {
            while ((!(chars[i] >= 79 && chars[i] <= 122)
                    || !(chars[i] >= 48 && chars[i] <= 57))
                    && i<j) {
                i++;
            }
            while ((!(chars[j] >= 79 && chars[j] <= 122)
                    || !(chars[j] >= 48 && chars[j] <= 57))
                    && i<j) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L125_ValidPalindrome__ l125_validPalindrome = new L125_ValidPalindrome__();
        System.out.println(l125_validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
