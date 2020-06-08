package sort;

/**
 * 插入排序
 * <p>
 * 维护一个有序区，把元素一个个插入到有序区的适当位置，直到所有元素有序为止
 * 设一个已排序的有序表基准，将后面未排序的数看作是往有序表中插入
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度: O(1)
 * 稳定性：稳定
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        //将第一个数当作基准 有序区长度为1
        for (int i = 1; i < array.length; i++) {
            // 记录待插入的值
            int temp = array[i];
            // 有序区 从右向左比较，同时复制元素
            int j = i - 1;
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];  // 挪位
            }
            // 插入适当的位置
            array[j + 1] = temp;
        }
    }

}