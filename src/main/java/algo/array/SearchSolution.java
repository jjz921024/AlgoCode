package algo.array;

import java.util.Arrays;

public class SearchSolution {

  /**
   *  leetcode 35 搜索插入位置
   *  利用二分搜索找左边界
   */
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
        right = mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      }
    }

    if (nums[left] >= target) return left; // 取大于时，表示没找到，插入在left位置上
    else return left + 1;  // 取nums[left] < target是，插入在left位置后
  }


  /**
   * leetcode 153 / 154
   * 旋转有序数组，找最小值
   */
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while(left < right) {
      int mid = left + (right - left) / 2;
      // 每次都与搜索区间右边界比较
      if (nums[mid] > nums[right]) {
        // 中值大于右值，最小值在中值右边，收缩左边界
        // 中值肯定不是最小值，可以跨过mid
        left = mid + 1;
      } else if (nums[mid] < nums[right]){
        // 中值小于右值，最小值在中值左边，收缩右边界
        // 因为中值可能是最小值，所以只能取到mid
        right = mid;
      } else {
        // 有重复元素时才会走到此分支
        // 只需
        right--;
      }
    }
    return nums[left];
  }


  /**
   * leetcode 287 找数组中唯一的重复元素
   * 数组长度n+1，元素范围 1~n
   * 要求：不能更改数组，时间复杂度小于O(n^2),空间复杂度O(1)
   */
  public int findDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;

      int count = 0;
      for (int num : nums) {
        if (num <= mid) count++;
      }

      // 抽屉原理：若小于等于n的个数 大于 n，那么1~n内存在重复元素
      if (count > mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }


}
