package leetcode;

public class L724_FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        for (int i =0; i<nums.length; i++) {
            if (sumLeft(nums, i) == total - nums[i] - sumLeft(nums, i)) {
                return i;
            }
        }
        return -1;
    }

    private int sumLeft(int[] num, int pivot) {
        int total = 0;
        for (int i =0; i<pivot; i++) {
            total += num[i];
        }
        return total;
    }


    public static void main(String[] args) {
        //int[] a = {1,7,3,6,5,6};
        int[] a = {-1,-1,-1,-1,-1,-1};
        System.out.println(new L724_FindPivotIndex().pivotIndex(a));
    }
}
