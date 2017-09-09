package utils.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jun on 2017/6/13.
 * 用于测试排序算法的数组，能实现复位功能
 */
public class ListSort {
    public int[] data;
    private int[] data_bak;

    public ListSort() {
        data = new int[]{9,1,5,8,3,7,4,6,2};
        data_bak = data.clone();
    }

    public ListSort(int size) {
        data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000);
        }
        data_bak = data.clone();
    }

    public void reset() {
        data = data_bak.clone();
    }

    public int getData(int i) {
        return data[i];
    }

    public void setData(int val, int i) {
        data[i] = val;
    }

    public int getLength() {
        return data.length;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(data) + '}';
    }

    public boolean isSorted() {
        for (int i=1; i<data.length; i++) {
            if (data[i-1] > data[i])
                return false;
        }
        return true;
    }
}
