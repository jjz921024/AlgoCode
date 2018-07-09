package leetcode;

/**
 * Created by Jun on 2018/7/9.
 */
public class L9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        String text = Integer.toString(x);
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_better(int x) {
        if(x < 0)
            return false;
        long revers = 0L;
        long temp = x;
        while(temp != 0){
            revers = 10 *revers + temp % 10;
            temp = temp / 10;
        }
        if (x == revers){
            return true;
        }
        return false;
    }
}