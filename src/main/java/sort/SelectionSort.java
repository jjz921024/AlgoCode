package sort;

import utils.sort.SortUtil;

/**
 * 选择排序
 * 在一轮排序中，通过多次比较找出当轮最小的数，再进行交换
 * 减少了交换的次数
 */
public class SelectionSort {

    public static void selectSort(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            min = i;
            //选定的关键字，跟后面的数据比较
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;  //找到最小数据的下标
                }
            }
            //第i小的数据不在第i个位置
            if (min != i) {
                SortUtil.swap(array, min, i);
            }
        }
    }
}
