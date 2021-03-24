package algo.hashmap;

import java.util.*;

public class NSum {

  /**
   * leetcode 1
   * Two Sum问题难点在于数组无序，面对无序数组：
   * 1. 排序后使用双指针
   * 2. 用HashMap或HashSet处理无序数组
   * <p>
   * 若给于有序数组求two sum，则可以使用左右指针 (套用二分查找模板)
   */
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 数值为key，数字下标为value
      // 相同nums[i]的时候下标会被覆盖，但不影响最后结果
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

  // 一次遍历解法
  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 若complement目前不在map中，等到target - complement时
      // 还是会回过头 获取到这组下标
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * leetcode 15 三数之和
   * 先对数组排序，再确定一个数，遍历调用two sum
   * 此时two sum返回的不是下标，而是值
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      List<List<Integer>> lists = twoSumHelper(nums, i + 1, 0 - nums[i]);
      // 把第三个数放入list中
      for (List<Integer> list : lists) {
        list.add(nums[i]);
        result.add(list);
      }

      // 如果下一个数相同则跳过，否则会出现重复
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }
    return result;
  }

  // 两数之和，返回元素的值，不能重复
  // 从start开始查找，数组已经有序
  // 左右指针
  private List<List<Integer>> twoSumHelper(int[] nums, int start, int target) {
    int left = start, right = nums.length - 1;
    ArrayList<List<Integer>> result = new ArrayList<>();

    while (left < right) {
      int tmp = nums[left] + nums[right];
      // 注意这种处理方法: 记录当前遍历的值，否则要在下面的while退出后再移动一次下标
      int leftVal = nums[left], rightVal = nums[right];

      // while循环目的，跳过重复元素
      if (tmp < target) {
        while (left < right && leftVal == nums[left]) left++;
        // left++;
      } else if (tmp > target) {
        while (left < right && rightVal == nums[right]) right--;

      } else {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[left]);
        res.add(nums[right]);
        result.add(res);
        while (left < right && leftVal == nums[left]) left++;
        while (left < right && rightVal == nums[right]) right--;
      }
    }
    return result;
  }


  /**
   * leetcode 454 四数之和
   */






}
