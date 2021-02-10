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
   * leetcode 34
   * 搜索左右边界
   */
  /*public int[] searchRange(int[] nums, int target) {

  }*/

  /**
   * leetcode 33
   * 旋转有序数组，判断是否存在指定数 todo
   */
  public int search(int[] nums, int target) {
    /*int left = 0, right = nums.length - 1;
    while(left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        return mid;
      }
    }*/
    return -1;
  }

  /**
   * leetcode 153 / 154
   * 旋转有序数组，找最小值  todo
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


  /**
   * leetcode 69 求平方根
   * todo review
   * 二分查找，注意边界，int类型溢出
   */
  public int mySqrt(int x) {
    int low = 0;
    int high = x;
    int res = -1;
    while (high - low >= 0) {
      int mid = low + (high - low) / 2;
      if ((long) mid * mid <= x) {
        res = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return res;
  }

  /**
   * leetcode 367 判断一个数是否是完全平方数
   * 逻辑同 leetcode 69
   */
  public boolean isPerfectSquare(int num) {
    int low = 0, high = num;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      long tmp = (long) mid * mid;
      if (tmp < num) {
        low = mid + 1;
      } else if (tmp > num) {
        high = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }


}
