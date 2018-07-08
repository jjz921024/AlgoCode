package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class hamming_distance_461 {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
