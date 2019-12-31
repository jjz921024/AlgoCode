package algo.matrix;

/**
 * Created by Jun on 2017/9/15.
 * 子数组的最大累加和/累积 问题
 * (子数组即是数组中一段连续的子区间)
 */
public class Max {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 先判断累加 再清零   注意全为负数的情况
            // 记录下当前遍历到的 最大累加子数组和
            max = sum > max ? sum : max;
            // 当累加和为负时，表明需要重新累加
            // 继续累加不可能出现最大值
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }

    //incorrect
    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        double cur = arr[0];
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
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
