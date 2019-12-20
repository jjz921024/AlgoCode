package leetcode.algo.matrix;

/**
 * Created by Jun on 2017/9/12.
 * 求出一个数组中待排序的最短子数组长度
 */
public class MinLengthSort {
    // 假设为升序
    public static int getMinLength(int[] arr) {
        int noMinIndex = -1;
        int min = arr[arr.length-1];
        // 从右往左扫描，找出乱序的前那个数 的下标
        for (int i=arr.length-2; i>=0; i--) {
            // 会找出出现乱序的数 中最小的下标
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                // 表明这个数字有序，替换需比较的最小值
                min = Math.min(min, arr[i]);
            }
        }
        // 数组原本就有序
        if (noMinIndex == -1) {
            return 0;
        }

        int noMaxIndex = -1;
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(getMinLength(new int[]{1, 5, 3, 4, 2, 6, 7}));
    }
}

