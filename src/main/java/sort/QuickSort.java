package sort;

import utils.sort.SortUtil;

import java.util.Arrays;

/**
 * 快速排序，属于交换排序的一种
 * 在每一轮选定一个基准元素，让比基准元素大的移动到序列一边，小的移动到另一边。
 * 将序列拆解成两部分继续递归 （分治法）
 *
 * 时间复杂度：平均：O(nlogn), 最差：O(n^2) 最佳：O(nlogn)
 * 每一轮需要比较全部元素n，需要进行logn轮
 * 空间复杂度：O(nlogn)
 * 稳定性：不稳定
 *
 * 缺点：在序列基本有序的情况下，时间复杂度会退化成O(n^2)
 * 适合无序序列的排序
 */
public class QuickSort {


    /**
     * 双边循环法
     * 从左右两端扫描序列，每轮将位于基准元素左边并大于它的元素交换，位于基准元素右边并小于它的元素交换
     * 再将左右的子序列递归
     */
    private static void quickSort(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 用序列的第一个元素做为基准元素，可改进
        int pivotKey = array[low];
        // 一轮扫描
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




    public static void main(String[] args) {
        SortUtil sortUtil = new SortUtil(10);
        int[] data = sortUtil.getData();
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

}
