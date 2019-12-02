package sort;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by Jun on 2017/8/23.
 * 位图法排序， 接收一个正整数的数组，数组无重复元素，输出排序后的数组
 */
public class BitmapSort {

    public static int[] bitmapSort(int[] arr) {
        int max = -1;
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        boolean[] bitArr = new boolean[max];

        for (int i : arr) {
            bitArr[i - 1] = true;
        }

        int[] res = new int[arr.length];
        int j = 0;
        for (int i = 0; i < bitArr.length; i++) {
            if (bitArr[i]) {
                res[j++] = i;
            }
        }
        return res;
    }

    public static int[] bitmapSortByBitset(int[] arr) {
        int max = -1;
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        BitSet bitSet = new BitSet(max);
        bitSet.clear();

        for (int i : arr) {
            bitSet.set(i - 1);
        }

        int[] res = new int[arr.length];
        int j = 0;
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                res[j++] = i;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 1, 77, 53, 72, 34, 23, 24, 64};
        int[] b = bitmapSortByBitset(a);
        System.out.println(Arrays.toString(b));
    }
}
