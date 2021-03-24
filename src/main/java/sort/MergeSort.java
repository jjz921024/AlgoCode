package sort;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二路归并排序
 * 1. 分组，将待排序元素逐层折半分组，直到每组只有一个元素为止
 * 2. 归并，先组内排序，再小组之间进一步比较和排序，合并成一个大组
 * <p>
 * 归并的主要步骤：
 * 1.创建一个额外的大集合用于存储归并结果，长度是两个小集合之和
 * 2.从左到右逐一比较两个小集合的元素，把较小的元素先放入大集合
 * 3.从另一个还有剩余元素的集合中，把剩余元素按顺序复制到大集合尾部
 * （此特性适合待排元素局部有序的情况）
 * <p>
 * <p>
 * 时间复杂度  平均：O(nlogn), 最差：O(nlogn) 最佳：O(nlogn)
 * 若集合长度为n, 则折半层数为logn, 每层操作运算量为n
 * 空间复杂读  O(n)
 * 每层需要创建的额外空间为n，但额外空间会随着方法调用结束而释放，不应该累加
 * 稳定性：稳定
 */
public class MergeSort {

    public static void mergeSort(int[] array, int start, int end) {
        if (array != null && start < end) {
            // 折半拆分成两个小集合，分别进行递归
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            // 把两个有序小集合归并成一个大集合
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        // 开辟额外的大集合
        int[] tempArray = new int[end - start + 1];
        // 分别设置小集合的指针
        int p1 = start, p2 = mid + 1, p = 0;
        // 分别比较两个小集合元素，依次放入大集合
        while (p1 <= mid && p2 <= end) {
            // 此处体现排序算法的稳定性
            if (array[p1] <= array[p2]) {
                tempArray[p++] = array[p1++];
            } else {
                tempArray[p++] = array[p2++];
            }
        }

        // 追加剩余元素
        while (p1 <= mid) {
            tempArray[p++] = array[p1++];
        }
        while (p2 <= end) {
            tempArray[p++] = array[p2++];
        }

        // 每次小集合归并完成后，复制回原数组，start标识小集合位置
        for (int i = 0; i < tempArray.length; i++) {
            array[i + start] = tempArray[i];
        }
    }

}
