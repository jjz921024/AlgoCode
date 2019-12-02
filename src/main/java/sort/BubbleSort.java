package sort;

import utils.sort.SortUtil;

/**
 * 冒泡排序
 * 时间复杂度  平均：O(n^2), 最差：O(n^2) 最佳：O(n)
 * 空间复杂读  O(1)
 * 稳定性：稳定
 */
public class BubbleSort {

    /**
     * 交换排序
     * 让每一个元素都和后面的每一个元素比较，使得该位置上的元素最小/大
     * 缺点：已排序的关键字对其他关键字排序没有帮助，无效的位置移动过多
     */
    public static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    SortUtil.swap(array, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //从后往前，外层排序会将前i个最小的值排序，所以j > i
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]){
                    SortUtil.swap(array, j - 1, j); //两两相邻
                }
            }
        }
    }

    /**
     * 冒泡排序改进
     */
    public static void bubbleSort3(int[] array) {
        //在比较时判断序列是否有序
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]){
                    SortUtil.swap(array, j - 1, j);
                    //若发生交换，则说明前面序列不是已排好序的
                    flag = true;
                }
            }
        }
    }
}
