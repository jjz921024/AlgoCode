package sort;

import utils.SortUtil;

/**
 * 堆排序
 * 1. 将待排序列构建成二叉堆 （从小到大排序构建最大堆，从大到小排序构建最小堆）
 * 2. 循环将所有堆顶元素替换到二叉堆的末尾，调整堆产生新的堆顶
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        // 构建最大堆
        for (int i = array.length / 2; i >= 0; i--)
            downAdjust(array, i, array.length);

        // 循环将堆顶元素与二叉堆末尾元素交换，调整堆产生新的堆顶
        // 下沉到末尾的结点不参与堆调整
        for (int i = array.length - 1; i >= 0; i--) {
            // 底层是数组
            SortUtil.swap(array, 0, i);
            // 重新调整堆结构
            downAdjust(array, 0, i);
        }
    }

    /**
     * 下沉调整  构建大顶堆
     * @param array 待调整的堆
     * @param parent 要下沉的节点
     * @param length 堆的有效大小, 即最后堆元素的下标
     */
    private static void downAdjust(int[] array, int parent, int length) {
        int temp = array[parent];
        // 序号从1开始时，若当前结点序号i，其左孩子序号为2i，右孩子序号2i+1
        // 调整子树，先找夫结点的左孩子2*parent
        for (int i = 2 * parent; i < length - 1; i *= 2) {
            // 找左右孩子中值大的
            if (i < length && array[i] < array[i + 1])
                i++;

            // 若根结点大于左右孩子，不用调整
            if (array[parent] >= array[i]) {
                break;
            } else {
                // 将孩子放到双亲结点上，根结点下沉
                array[parent] = array[i];
                parent = i; //继续向下找
            }
            array[parent] = temp; //被调整的值放入最终位置    因为是从下往上逐层调整，所以深度最多为1
        }
    }

}

