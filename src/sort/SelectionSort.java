package sort;

import utils.sort.ListSort;
import utils.sort.Util;

/**
 * Created by Jun on 2017/6/14.
 * 选择排序  在一轮排序中，通过多次比较找出当轮最小的数，再进行交换
 * 减少了交换的次数
 */
public class SelectionSort {

    public static void selectSort(ListSort list) {
        int min = 0;
        for (int i = 0; i < list.getLength(); i++) {
            min = i;
            //选定的关键字，跟后面的数据比较
            for (int j = i; j < list.getLength(); j++) {
                if (list.getData(min) > list.getData(j)) {
                    min = j;  //找到最小数据的下标
                }
            }
            //第i小的数据不在第i个位置
            if (min != i) {
                Util.swap(list, min, i);
            }
        }
    }
}
