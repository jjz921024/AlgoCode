package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
