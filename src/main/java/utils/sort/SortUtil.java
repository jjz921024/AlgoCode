package utils.sort;

import java.util.Random;

/**
 * Created by Jun on 2017/6/13.
 */
public class SortUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //用于测试排序算法的数组，能实现复位功能
    public int[] data;
    private int[] dataBak;

    public SortUtil() {
        this(1024);
    }

    public SortUtil(int size) {
        data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000);
        }
        dataBak = data.clone();
    }

    public void reset() {
        data = dataBak.clone();
    }

    public boolean isSorted() {
        for (int i=1; i<data.length; i++) {
            if (data[i-1] > data[i])
                return false;
        }
        return true;
    }
}
