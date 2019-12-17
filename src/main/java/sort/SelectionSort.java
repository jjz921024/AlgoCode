package sort;

import utils.sort.SortUtil;

/**
 * 选择排序
 * 在一轮排序中，通过多次比较找出当轮最小的数，再进行交换
 * 减少了交换的次数
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度: O(1)
 * 稳定性：不稳定
 */
public class SelectionSort {

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            // 遍历数据，找到最小数据的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // 第i小的数据不在第i个位置
            if (min != i) {
                SortUtil.swap(array, min, i);
            }
        }
    }
}
