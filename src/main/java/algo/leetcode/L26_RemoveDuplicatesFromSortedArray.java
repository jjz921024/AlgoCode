package algo.leetcode;

/**
 * Created by Jun on 2018/7/9.
 */
public class L26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int flag = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[flag]) {
                flag++;
                nums[flag] = nums[i];
            }
        }
        return flag+1;
    }
}
