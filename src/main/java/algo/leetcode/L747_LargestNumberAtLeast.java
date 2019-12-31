package algo.leetcode;

import java.util.Arrays;

public class L747_LargestNumberAtLeast {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max_idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                max_idx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != max_idx && nums[i] * 2 > max) {
                return -1;
            }
        }
        return max_idx;
    }

    // 找到第二大的数与最大数比较
    public int dominantIndex_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int max_idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                max_idx = i;
            }
        }

        Arrays.sort(nums);
        if (nums[nums.length -2] * 2 > max) {
            return -1;
        }
        return max_idx;

    }

    public static void main(String[] args) {
        int[] a = {0,0,0,1};
        System.out.println(new L747_LargestNumberAtLeast().dominantIndex_2(a));
    }
}
