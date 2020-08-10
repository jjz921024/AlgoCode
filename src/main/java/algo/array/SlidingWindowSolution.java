package algo.array;

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

}
