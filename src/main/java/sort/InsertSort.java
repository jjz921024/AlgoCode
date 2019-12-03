package sort;

/**
 * 插入排序
 * 设一个已排序的有序表基准，将后面未排序的数看作是往有序表中插入
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        //将第一个数当作基准 i=1
        for (int i = 1; i < array.length; i++) {
            // 当前待排序的数，与已排序的基准比较
            if (array[i] < array[i - 1]) {
                int j = 0;
                int temp = array[i];
                // 有序表后移，找当前数据应插入的位置
                for (j = i; j > 0 && array[j - 1] > temp; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
            }
        }
    }

}
