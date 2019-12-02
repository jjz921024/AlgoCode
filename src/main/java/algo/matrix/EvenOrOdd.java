package algo.matrix;

import utils.sort.SortUtil;

import java.util.Arrays;

/**
 * Created by Jun on 2017/9/15.
 * 调整长度不小于2的数组，使得奇数下标全为奇数或者偶数下标全为偶数
 */
public class EvenOrOdd {
    public static void modifty(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int even = 0;
        int odd = 1;
        int idx = arr.length - 1;
        while (even <= idx && odd <= idx) {
            if (arr[idx] % 2 == 0) {
                SortUtil.swap(arr, idx, even);
                even += 2;
            } else {
                SortUtil.swap(arr, odd, idx);
                odd += 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 2, 5, 7, 4, 2, 4};
        modifty(data);
        System.out.println(Arrays.toString(data));
    }
}
