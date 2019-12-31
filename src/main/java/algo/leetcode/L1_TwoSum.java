package algo.leetcode;

import java.util.HashMap;

/**
 * Created by Jun on 2018/7/23.
 */
public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int newTarget = target - nums[i];
            if (hashMap.containsKey(newTarget) && hashMap.get(newTarget) != i) {
                return new int[]{hashMap.get(newTarget), i};
            }
        }
        return null;
    }
}
