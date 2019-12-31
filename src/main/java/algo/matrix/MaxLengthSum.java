package algo.matrix;

/**
 * Created by Jun on 2017/9/12.
 * 求数组中累加和为k的 最长子数组长度
 */
public class MaxLengthSum {
    //正整数数组情况
    public static int getMaxLength(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int len = 0;
        int sum = arr[0];
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right-left+1);
                sum -= arr[left++];

            } else if (sum < k) {
                right++;
                if (right == arr.length)
                    break;
                sum += arr[right];

            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        System.out.println(getMaxLength(new int[]{1, 2, 2, 4, 2,}, 7));
    }
}
