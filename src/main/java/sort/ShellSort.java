package sort;

/**
 * 希尔排序
 * 在插入排序的基础上，
 * - 若大多数元素已经有序的情况下，插入排序的工作量较小
 * - 若元素数量较少的情况下，插入排序的工作量较小
 * 通过让元素分组排序，使得大部分元素变得有序，组内使用插入排序
 * 直到分组跨度为1，相当于使用插入排序为止
 * <p>
 * 分组跨度称为希尔排序的增量，样例中使用逐步折半的增量方法
 * 由于每轮的希尔增量是等比的，因此存在盲区，会增加无用的操作成本
 * <p>
 * 时间复杂度：最佳O(n^1.3)，  Hibbard增量 O(n^(3/2)),  Sedgewick增量O(n^(4/3))
 * 空间复杂度: O(1)
 * 稳定性：不稳定
 */
@SuppressWarnings("Duplicates")
public class ShellSort {

    public static void shellSort(int[] array) {
        int d = array.length;
        // 直达增量为1为止, 最后能取到d=1
        while (d > 1) {
            // 希尔增量的方式，每次折半
            d = d / 2;
            // 每轮使用插入排序
            for (int x = 0; x < d; x++) {
                // 插入排序
                // 第一个元素为有序区
                for (int i = x + d; i < array.length; i = i + d) {
                    // 待插入元素
                    int temp = array[i];
                    // 与有序区最右边比较，跨度为d
                    int j = i - d;
                    for (; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }

    }

    public static void shellSort2(int[] array) {
        int d = 1;
        while (d < array.length) {
            d = d * 3 + 1;
        }
        while (d > 1) {
            d = d / 3;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j = i - d;
                    for (; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }
}
