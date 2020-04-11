package algo.hashmap;

/**
 * Created by Jun on 2018/7/8.
 * leetcode 136
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
