package algo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDup {

  /**
   * 判断数组是否存在重复元素
   * leetcode 217
   */
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    return nums.length != set.size();
  }


  /**
   * 判断数组中是否存在相同的数，且它们下标之差的绝对值不大于k
   * leetcode 219
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    // key存int， value存index
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 边遍历边判断
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

}
