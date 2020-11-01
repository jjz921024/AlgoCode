package algo.array;

import java.util.LinkedList;

public class OtherSolution {

  /**
   * leetcode 238  除自身外数组的乘积
   * 不能用除法， O(n)时间复杂度，不使用额外空间
   */
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    // result[i] 代表下标i左边所有元素乘积
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      // 累乘
      result[i] = result[i - 1] * nums[i - 1];
    }

    // tmp为右侧所有元素乘积
    int tmp = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      // 对于下标i，左边元素乘积为result[i]，右边元素乘积为tmp
      result[i] = result[i] * tmp;
      tmp *= nums[i];  // 累乘右侧元素
    }

    return result;
  }



  // todo
  public int numSquares(int n) {
    int bound = (int) Math.floor(Math.sqrt(n));
    LinkedList<Integer> result = new LinkedList<>();
    backtrack(bound, n, new LinkedList<>(), result);
    return result.size();
  }

  private void backtrack(int bound, int target, LinkedList<Integer> track, LinkedList<Integer> result) {
    if (target < 0) return;
    else if (target == 0) {
      if (result.isEmpty() || result.size() > track.size())
        result = new LinkedList<>(track);
    }

    for (int i = bound; i > 0; i--) {
      track.add(i);
      backtrack(bound, target - i * i, track, result);
      track.removeLast();
    }
  }
}
