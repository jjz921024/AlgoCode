package algo.leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class L461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
