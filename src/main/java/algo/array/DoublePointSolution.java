package algo.array;

import utils.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 双指针技巧 - 左右指针
 * 通常用于数组和二分查找，数组可以方便移动左右指针
 */
public class DoublePointSolution {

  /**
   * leetcode 167
   * 升序排列的有序数组，找到两个数之和等于目标
   * 返回这两个数的下标，下标小的在前
   */
  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int result = target - numbers[left] - numbers[right];
      if (result == 0) {
        return new int[]{left + 1, right + 1};
      } else if (result > 0) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * leetcode 26 删除排序数组中重复项，返回新数组长度
   * 设置快慢指针，i是快指针，flag是慢指针，也表示新数组边界
   * 当i和flag指向的值不等时，新数组边界右移
   */
  public int removeDuplicates(int[] nums) {
    int flag = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[flag]) { // 不相等时，扩张新数组边界
        flag++;
        nums[flag] = nums[i];
      }
    }
    return flag + 1;
  }


  /**
   * leetcode 125 验证回文字符串
   * 左右指针
   * 0P 零和P的ascii码也差32，先转化大小写
   */
  public boolean isPalindrome(String s) {
    if (s == null || "".equals(s)) return true;

    char[] chars = s.toLowerCase().toCharArray();

    int left = 0, right = chars.length - 1;
    while (left < right) {
      // 只考虑字母和数字，忽略大小写
      if (!isValid(chars[left])) {
        left +=1;
        continue;
      }
      if (!isValid(chars[right])) {
        right -=1;
        continue;
      }

      if (chars[left] != chars[right]) {  // && Math.abs(chars[left] - chars[right]) != 32
        return false;
      }
      left += 1;
      right -= 1;
    }
    return true;
  }

  private boolean isValid(char c) {
    return ((c >= 65 && c <= 90) // 大写字母
    || (c >= 97 && c <= 122)  // 小写字母
    || (c >= 48 && c <= 57)); // 数字
  }


  /**
   * leetcode 283 移动零到末尾
   */
  public void moveZeroes(int[] nums) {
    // bound指针之前的都是非0元素
    int cur = 0, bound = 0;

    while (cur < nums.length) {
      // 遇到非0元素，将它放到bound位置，然后两指针往前走
      // 遇到0元素，当前指针往前走
      if (nums[cur] != 0) {
        int tmp = nums[cur];
        nums[cur++] = nums[bound];
        nums[bound++] = tmp;
      } else {
        cur++;
      }
    }
  }

  /**
   * leetcod 581 找出最短无序子数组，使整个数组能升序
   * todo
   */
  public int findUnsortedSubarray(int[] nums) {
    if (nums.length <= 1) return 0;

    int left = 0, right = nums.length - 1;

    while (left < nums.length - 1 && nums[left] <= nums[left + 1]) left++;
    while (right > 0 && nums[right] >= nums[right - 1]) right--;

    return right - left < 0 ? 0 : right - left + 1;
  }

  /**
   * leetcode 11 盛水容器
   */
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int max = Integer.MIN_VALUE;

    while (left < right) {
      int width = right - left;
      max = Math.max(max, width * Math.min(height[left], height[right]));

      // 移动高度低的那边
      // 若两边高度一样，那么只移动任意一边面积都不会增大。这种情况下，更大的面积只会出现在两侧都移动后
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  /**
   * leetcode 349 / 350
   * 求两个数组交集 排序+双指针
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int p1 = 0, p2 = 0, idx = 0;
    int len = Math.max(nums1.length, nums2.length);
    int[] res = new int[len];
    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] < nums2[p2]) {
        p1++;
      } else if (nums1[p1] > nums2[p2]) {
        p2++;
      } else {
        if (idx == 0 || res[idx - 1] != nums1[p1]) {
          res[idx++] = nums1[p1];  // leetcode 350 不去重
        }
        p1++;
        p2++;
      }
    }
    return Arrays.copyOf(res, idx);
  }

  /**
   * leetcode 392 判断s是否是t的子序列
   * 双指针
   * todo 动态规划解法
   */
  public boolean isSubsequence(String s, String t) {
    int p1 = 0, p2 = 0;
    while (p1 < s.length() && p2 < t.length()) {
      if (s.charAt(p1) == t.charAt(p2)) {
        p1++;
      }
      p2++;
    }
    return p1 == s.length();
  }

  /**
   * leetcode 88
   * 合并两个有序数组
   * num1有足够空间，m为nums1种元素个数
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1, p2 = n - 1, pos = m + n - 1;
    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] >= nums2[p2]) {
        nums1[pos--] = nums1[p1--];
      } else {
        nums1[pos--] = nums2[p2--];
      }
    }
    while (p2 >= 0) {
      nums1[pos--] = nums2[p2--];
    }
  }


  /**
   * leetcode 763 划分字母区间
   * 每个片段尽可能短，才能划分出最多的片段
   * 但每个字母只能出现在一个片段中，所以要找到该片段中所有字母的最远位置
   * todo 贪心算法如何做？
   */
  public List<Integer> partitionLabels(String S) {
    List<Integer> res = new ArrayList<>();
    while (S.length() != 0) {
      int temp = S.lastIndexOf(S.charAt(0));
      // 找最远位置
      int max = 0;
      for (int i = 0; i < temp; i++) {
        max = Math.max(S.lastIndexOf(S.charAt(i)), max);
        // 用例：“qiejxqfnqceocmy”, 第一次的边界要扩展
        temp = max;
      }

      S = S.substring(max + 1);
      res.add(max + 1);
    }
    return res;
  }



}
