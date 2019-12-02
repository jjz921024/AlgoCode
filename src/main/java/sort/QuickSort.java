package sort;

import utils.sort.SortUtil;

/**
 * Created by Jun on 2017/9/10.
 * 快速排序：选定一个枢轴值，从左右两端扫描序列，每次扫描将其中位于枢轴值左边并大于它的元素交换，右边相同。
 * 再将枢轴值左右的子序列递归操作
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        qSort(array, 0, array.length - 1);
    }

    private static void qSort(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(array, low, high);
            qSort(array, low, pivot - 1);
            qSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 用子表的第一个数做枢轴值，可改进
        int pivotKey = array[low];
        while (low < high) {
            //从右端扫描，将大于枢轴值的一条记录移至右边
            while (low < high && array[high] >= pivotKey)
                high--;
            SortUtil.swap(array, low, high);
            // 从左端扫描，将小于枢轴值的一条记录移至左边
            while (low < high && array[low] <= pivotKey)
                low++;
            SortUtil.swap(array, low, high);
        }
        // 返回枢轴值所在的位置
        return low;
    }

}
