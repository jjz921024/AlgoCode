package algo.array;

import java.util.*;

public class SortSolution {

  /**
   * leetcode 347
   * 返回数组中出现频率最高的前k个元素
   * 利用小顶推对频率排序
   */
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      // num为key，频数为value
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // 对map中的value排序
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o1) - map.get(o2);
      }
    });

    for (Integer key : map.keySet()) {
      if (queue.size() < k) {
        queue.add(key);
      } else if (map.get(queue.peek()) < map.get(key)) {
        queue.poll();
        queue.add(key);
      }
    }

    int[] result = new int[k];
    int i = 0;
    while (!queue.isEmpty()) {
      result[i++] = queue.poll();
    }
    return result;
  }


  /**
   * leetcode 532 diff对
   */
  public int findPairs(int[] nums, int k) {
    if(nums.length < 2) return 0;
    Arrays.sort(nums);

    int count = 0;
    for(int i = 0; i < nums.length; i++) {
      // 跳过重复数 (1, 1, 3) -> (1, 3), (1, 3)
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i+1; j < nums.length; j++) {
        if(nums[j] - nums[i] == k) {
          count++;
          // 如果相等也跳出循环，右端点的重复树由外层判断
          // (1, 3, 3) -> (1, 3), (1, 3)
          break;
        } else if(nums[j] - nums[i] > k)
          break;
      }
    }
    return count;
  }

  /**
   * leetcode 1365 有多少小于当前数字的数字
   * 升序排序后，你的索引就是有多少个数字小于你
   * todo
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    Arrays.sort(nums);
    int[] res = new int[nums.length];
    char c= '2';

    return null;
  }


}
