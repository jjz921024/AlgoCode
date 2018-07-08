package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class power_of_tow_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & n - 1) == 0;
    }
}
