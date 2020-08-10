package algo.hashmap;

import java.util.HashMap;

/**
 * Created by Jun on 2018/7/23.
 * leetcode 1
 */
public class TwoSum {

    // 也可优化成边遍历边判断
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 数值为key，数字下标为value
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            if (hashMap.containsKey(newTarget) && hashMap.get(newTarget) != i) {
                return new int[]{hashMap.get(newTarget), i};
            }
        }
        return null;
    }
}
