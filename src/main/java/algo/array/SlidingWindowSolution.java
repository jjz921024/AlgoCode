package algo.array;

import org.hamcrest.core.Is;

public class SlidingWindowSolution {

  /**
   * leetcode 485
   * 数组中 最大连续1的个数
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    int left = 0;
    int right = 0;
    int max = 0;
    for(; right < nums.length; right++) {
      if(nums[right] == 0) {
        // 不需要 right - left + 1
        max = Math.max((right - left), max);
        left = right + 1;
      }
    }
    // 假如全为1的情况判断不到
    max = Math.max((right - left), max);
    return max;
  }

  /**
   * leetcode 53 最大子序和
   * todo
   */
  public int maxSubArray(int[] nums) {
    int left = 0, right = 0;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    while (right < nums.length) {
      sum += nums[right];
      right++;

      if (sum > maxSum) {
        maxSum = sum;
      } else {
        while (left < right) {
          sum -= nums[left];
          left++;
          maxSum = Math.max(maxSum, sum);
        }
        sum = 0;
      }
    }

    return maxSum;
  }



}
