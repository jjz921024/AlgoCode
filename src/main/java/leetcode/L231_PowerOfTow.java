package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class L231_PowerOfTow {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & n - 1) == 0;
    }
}
