package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class single_number_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
