package question.queue;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Jun on 2017/8/16.
 * 生成一个数组的  窗口最大值数组
 */
public class MaxWindow {

    public static int[] getSumWindow(int[] data, int w) {
        int[] window = new int[w];
        int[] res = new int[data.length-w+1];
        int idx = w;
        for (int i=0; i<w; i++) {
            window[i] = data[i];
        }

        int count = 0;
        while (count != data.length - w + 1) {
            res[count++] = window[0] + window[1] + window[2];
            window[idx % w] = data[(idx == data.length) ? data.length-1 : idx++];
        }
        return res;
    }

    public static int[] getMaxWindow(int[] data, int w) {
        if (data == null || w <1 || data.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[data.length-w+1];

        for (int i=0; i<data.length; i++) {


        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getSumWindow(ints, 3);
        System.out.println(Arrays.toString(res));
    }
}
