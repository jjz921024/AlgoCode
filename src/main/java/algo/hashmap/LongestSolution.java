package algo.hashmap;

import java.util.HashMap;

public class LongestSolution {

  /**
   * leetcode 594
   * 最长和谐子序列
   * 子序列中最大最小值之差刚好为1
   */
  public int findLHS(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int result = 0;
    for (int num : map.keySet()) {
      Integer a = map.get(num);
      Integer b = map.get(num + 1);
      if (b != null && a + b > result) {
        result = a + b;
      }
    }
    return result;
  }



}
