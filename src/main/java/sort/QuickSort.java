package sort;

import utils.SortUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序，属于交换排序的一种
 * 在每一轮选定一个基准元素，让比基准元素大的移动到序列一边，小的移动到另一边。
 * 将序列拆解成两部分继续递归 （分治法）
 * <p>
 * 时间复杂度：平均：O(nlogn), 最差：O(n^2) 最佳：O(nlogn)
 * 每一轮需要比较全部元素n，需要进行logn轮
 * 空间复杂度：O(nlogn)
 * 稳定性：不稳定
 * <p>
 * 缺点：在序列基本有序的情况下，时间复杂度会退化成O(n^2)
 */
public class QuickSort {

    /**
     * partition方法实现让数列中的元素分别移动到基准元素的两边
     * 返回基准元素的下标
     * 再将左右的子序列递归
     */
    public static void quickSort(int[] array, int low, int high) {
        int pivotIndex;
        if (low < high) {
            pivotIndex = partition3(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * 非递归实现
     * 维护一个栈，栈中保存每一次方法调用的参数
     */
    public static void quickSort2(int[] array, int low, int high) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        // 第一次调用的参数入栈
        HashMap<String, Integer> paramMap = new HashMap<>();
        paramMap.put("low", low);
        paramMap.put("high", high);
        stack.push(paramMap);

        // 栈空时循环结束
        while (!stack.isEmpty()) {
            // 弹出参数，调用partition方法
            Map<String, Integer> param = stack.pop();
            int pivotIndex = partition3(array, param.get("low"), param.get("high"));

            // 根据基准元素将参数分为两部分，分别入栈
            if (param.get("low") < pivotIndex - 1) {
                HashMap<String, Integer> lowParam = new HashMap<>();
                lowParam.put("low", param.get("low"));
                lowParam.put("high", pivotIndex - 1);
                stack.push(lowParam);
            }
            if (param.get("high") > pivotIndex + 1) {
                HashMap<String, Integer> highParam = new HashMap<>();
                highParam.put("low", pivotIndex + 1);
                highParam.put("high", param.get("high"));
                stack.push(highParam);
            }
        }
    }

    /**
     * 填坑法
     * 每轮将位于基准元素左边并大于它的元素交换，位于基准元素右边并小于它的元素交换
     */
    private static int partition1(int[] array, int low, int high) {
        // 用序列的第一个元素做为基准元素，可改进
        int pivot = array[low];
        // 一轮扫描
        while (low < high) {
            //从右端扫描，将大于基准元素的一条记录移至右边
            while (low < high && array[high] >= pivot) {
                high--;
            }
            SortUtil.swap(array, low, high);

            // 从左端扫描，将小于基准元素的一条记录移至左边
            while (low < high && array[low] <= pivot) {
                low++;
            }
            SortUtil.swap(array, low, high);
        }
        // 返回基准元素所在的位置
        return low;
    }

    /**
     * 双边循环法 / 指针交换法
     * 在数列头尾设置low和high指针，从左右两端扫描数列
     * 从high指针开始，把所指向元素和基准元素比较，若大于等于pivot则向左移动，小于pivot则停止移动切换到low指针
     * 同理，若low指针指向元素小于等于pivot则向右移动，大于pivot则停止移动，这时交换low和high指向的元素
     */
    private static int partition2(int[] array, int low, int high) {
        int pivot = array[low];
        // 记录下开始时pivot的下标，供最后pivot和重合点交换使用
        int startIndex = low;
        while (low < high) {
            // 控制high指针左移，找到小于pivot的元素
            while (low < high && pivot <= array[high]) {
                high--;
            }

            // 控制low指针右移，找到大于pivot的元素
            while (low < high && pivot >= array[low]) {
                low++;
            }

            // 交换左右指针的元素
            if (low < high) {
                SortUtil.swap(array, low, high);
            }
        }

        // 左右指针重合，一轮分区结束
        // 将pivot和重合点位置的元素交换
        int temp = array[low];
        array[low] = pivot;
        array[startIndex] = temp;
        return low;
    }

    /**
     * 单边循环法
     * 设置一个mark指针指向数组开始位置，mark指针代表小于基准元素的边界区域
     * 开始遍历，若遍历到的元素大于基准元素则继续
     * 若小于基准元素，则mark指针右移一位，表示边界区域增大；
     * 然后该元素和mark指针指向的元素交换，表示将该元素归纳到小于pivot的区域
     */
    private static int partition3(int[] array, int low, int high) {
        int pivot = array[low];
        int mark = low;

        // 遍历元素
        for (int i = mark + 1; i <= high; i++) {
            // 小于基准元素时
            if (array[i] < pivot) {
                mark++;
                SortUtil.swap(array, i, mark);
            }
        }

        // 将pivot元素交换到mark指针指向的地方
        array[low] = array[mark];
        array[mark] = pivot;
        return mark;
    }

}
