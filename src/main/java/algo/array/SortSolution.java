package algo.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

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

}
