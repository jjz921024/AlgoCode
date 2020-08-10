package algo.array;

/**
 * leetcode 724
 */
public class FindPivotIndex {

  public int pivotIndex(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }

    for (int i = 0; i < nums.length; i++) {
      int sumLeft = sumLeft(nums, i);
      if (sumLeft == total - nums[i] - sumLeft) {
        return i;
      }
    }
    return -1;
  }

  private int sumLeft(int[] num, int pivot) {
    int total = 0;
    for (int i = 0; i < pivot; i++) {
      total += num[i];
    }
    return total;
  }

}
