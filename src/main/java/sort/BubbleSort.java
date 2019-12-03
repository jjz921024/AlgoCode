package sort;

import utils.sort.SortUtil;

/**
 * 冒泡排序, 属于交换排序的一种
 * 时间复杂度  平均：O(n^2), 最差：O(n^2) 最佳：O(n)
 * 空间复杂读  O(1)
 * 稳定性：稳定
 */
public class BubbleSort {

    /**
     * 交换排序
     * 让每一个元素都和后面的每一个元素比较，使得该位置上的元素最小/大
     * 缺点：已排序的元素对其他元素排序没有帮助，无效的比较和位置移动过多
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
     * 外部循环控制所有回合，内部循环实现每一轮的排序
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 每次将最大的元素排到最后面
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                }
            }
        }
    }

    // 从后往前排，先排最大元素
    public static void bubbleSort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //从后往前，外层排序会将前i个最小的值排序，所以j > i
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    SortUtil.swap(array, j - 1, j); //两两相邻
                }
            }
        }
    }

    /**
     * 冒泡排序改进
     * 在每一轮冒泡过程中，**若没有发生元素之间的位置交换**，则说明序列已经有序，可以中止排序
     * 提前知道待排序列已经处于有序状态，提前结束排序，进一步减少无意义的比较和交换
     */
    public static void bubbleSort4(int[] array) {
        // 标志位表示序列目前还无序
        boolean unsorted = true;
        for (int i = 0; i < array.length && unsorted; i++) {
            // 先暂时设为有序
            unsorted = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    SortUtil.swap(array, j - 1, j);
                    // 若发生元素交换，则说明前面序列不是有序的
                    unsorted = true;
                }
            }
        }
    }

    /**
     * 冒泡排序改进
     * 若初始时，从序列头或尾开始有一段有序区，则每一轮冒泡过程中还会多余的比较有序区中的元素
     * 在每轮冒泡过程中，界定出有序区的范围，更进一步减少比较次数
     *
     * 例子， [3,4,2,1,5,6,7,8]中，后半部分元素(5开始)为有序区，但前几轮冒泡还是会对5，6，7，8进行比较
     */
    public static void bubbleSort5(int[] array) {
        boolean unsorted = true;
        // 待排序区域的上边界
        int sortedIndex = array.length - 1;
        for (int i = 0; i < array.length - 1 && unsorted; i++) {
            unsorted = false;
            int temp = 0;
            for (int j = 0; j < sortedIndex; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                    unsorted = true;
                    // 记录最后一次元素交换的位置
                    temp = j + 1;
                }
            }
            // 把待排序边界更新为最后一次元素交换的位置
            sortedIndex = temp;
        }
    }

}