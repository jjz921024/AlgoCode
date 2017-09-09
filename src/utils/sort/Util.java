package utils.sort;

/**
 * Created by Jun on 2017/6/13.
 */
public class Util {
    public static void swap(ListSort list, int i, int j) {
        int temp = list.getData(i);
        list.setData(list.getData(j), i);
        list.setData(temp, j);
    }
}
