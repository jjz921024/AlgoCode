package utils;

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

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    //用于测试排序算法的数组，能实现复位功能
    private int[] data;
    private int[] dataBak;

    public SortUtil() {
        this(1024);
    }

    public SortUtil(int size) {
        data = new int[size];
        dataBak = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000);
            dataBak[i] = data[i];
        }
    }

    // 返回值相同的数组，不改变data数组的引用
    public void reset() {
        System.arraycopy(dataBak, 0, data, 0, data.length);
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000);
            dataBak[i] = data[i];
        }
    }

    public int[] getData() {
        return data;
    }
}
