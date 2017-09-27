package sort;

import org.junit.Test;
import utils.sort.ListSort;

/**
 * Created by Jun on 2017/9/8.
 * 简单插入排序
 * 设一个已排序的有序表基准，将后面未排序的数看作是往有序表中插入
 */
public class InsertSort {

    public static void insertSort(ListSort list) {
        //将第一个数当作基准 i=1
        for (int i=1; i<list.getLength(); i++) {
            // 当前待排序的数，与已排序的基准比较
            if (list.getData(i) < list.getData(i-1)) {
                int j = 0;
                int temp = list.getData(i);
                // 有序表后移，找当前数据应插入的位置
                for (j=i; j>0 && list.getData(j-1) > temp; j--) {
                    list.setData(list.getData(j-1), j);
                }
                list.setData(temp, j);
            }
        }
    }


    @Test
    public void test() {
        ListSort listSort = new ListSort(20);
        System.out.println(listSort.toString() + listSort.isSorted());
        insertSort(listSort);
        System.out.println(listSort.toString() + listSort.isSorted());
    }
}
