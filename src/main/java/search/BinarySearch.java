package search;

import org.junit.Test;

/**
 * Created by Jun on 2017/9/6.
 * 二分查找
 * 在数组中查找指定值的元素，返回元素所在数组下标。未找到返回-1
 */
public class BinarySearch {

    // todo 递归版本
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length;
        int count = 1;
        // 当low=high时是最后一次查找
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < a[mid]) {
                System.out.println("第"+count++ +"次查找 --> low：" + low + "  high: "+ high + "  mid: " + mid);
                high = mid - 1;
            } else if (key > a[mid]) {
                System.out.println("第"+count++ +"次查找 --> low：" + low + "  high: "+ high + "  mid: " + mid);
                low = mid + 1;
            } else {
                System.out.println("第"+count +"次查找，找到 "+key+" 在第 "+mid+" 位置");
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] data = new int[]{3,5,8,9,13,15,19,22};
        binarySearch(data, 1);
    }
}
