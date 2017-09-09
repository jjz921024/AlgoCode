package sort;

import utils.sort.ListSort;
import utils.sort.Util;

/**
 * Created by Jun on 2017/6/13.
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 交换排序
     * 让每一个关键字都和后面的每一个关键字比较，使得该位置关键字最小/大
     * 缺点：已排序的关键字对其他关键字排序没有帮助，无效的位置移动过多
     */
    public static void bubbleSort1(ListSort list) {
        for (int i = 0; i < list.getLength(); i++) {
            for (int j = i + 1; j < list.getLength(); j++) {
                if (list.getData(i) > list.getData(j)) {
                    Util.swap(list, i, j);
                }
            }
        }
    }

    /**
     *
     */
    public static void bubbleSort2(ListSort list) {
        for (int i = 0; i < list.getLength(); i++) {
            //从后往前，外层排序会将前i个最小的值排序，所以j > i
            for (int j = list.getLength() - 1; j > i; j--) {
                if (list.getData(j - 1) > list.getData(j)){
                    Util.swap(list, j - 1, j); //两两相邻
                }
            }
        }
    }

    public static void bubbleSort3(ListSort list) {
        //在比较时判断序列是否有序
        boolean flag = true;
        for (int i = 0; i < list.getLength() && flag; i++) {
            flag = false;
            for (int j = list.getLength() - 1; j > i; j--) {
                if (list.getData(j - 1) > list.getData(j)){
                    Util.swap(list, j - 1, j);
                    //若发生交换，则说明前面序列不是已排好序的
                    flag = true;
                }
            }
        }
    }
}
