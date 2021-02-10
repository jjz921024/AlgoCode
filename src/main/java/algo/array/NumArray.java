package algo.array;

/**
 * leetcode 303
 */
public class NumArray {

  private int[] prefixSum;

  // 前序和
  public NumArray(int[] nums) {
    prefixSum = new int[nums.length + 1];
    int sum = 0;
    for (int i = 1; i <= nums.length; i++) {
      sum += nums[i - 1];
      prefixSum[i] = sum;
    }

  }

  public int sumRange(int i, int j) {
    return prefixSum[j + 1] - prefixSum[i];
  }

}
