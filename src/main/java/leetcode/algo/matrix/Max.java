package leetcode.algo.matrix;

/**
 * Created by Jun on 2017/9/15.
 * 子数组的最大累加和/累积 问题
 */
public class Max {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int sum = 0;
        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            max = sum > max ? sum : max; //先判断累加 再清零   注意全为负数的情况
            sum = sum < 0 ? 0 :sum;
        }
        return max;
    }

    //incorrect
    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        double cur = arr[0];
        double max = arr[0];
        for (int i=1; i<arr.length; i++) {
            cur *= arr[i];
            max = cur > max ? cur : max;
        }
        return max;
    }

    public static void main(String[] args) {
        double[] data = {-1, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxProduct(data));
    }
}
