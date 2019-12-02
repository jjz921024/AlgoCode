package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 多路归并排序
 *
 * （每个集合内文件有序）
 * 对每个集合维护一个指针，每次取出K个指针中指向元素最小的一个，
 * 然后把最小的指针后移，如此循环
 *
 * 实现：用一个最小堆来维护K个指针，每次从堆中取最小值
 *
 * 时间复杂度：O(nlogk)
 * 每次从堆中取指针为logk，最多取n次
 */
public class MultiMergeSort {

    public static int[] kMergeSort(int[]... arrayList) {
        // 创建一个最小堆
        PriorityQueue<Pair> heap = new PriorityQueue<>(arrayList.length, (o1, o2) -> o1.array[o1.point] - o2.array[o2.point]);

        int totalSize = 0;
        for (int[] array : arrayList) {
            if (array.length > 0) {
                heap.add(new Pair(array));
                totalSize += array.length;
            }
        }

        // 额外开辟临时数组
        int[] tempArray = new int[totalSize];

        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            // 依次按大小  指针后移
            tempArray[tempArray.length - totalSize--] = current.array[current.point++];
            if (current.hanNext()) {
                heap.add(current);
            }
        }

        return tempArray;
    }

    static class Pair {
        int[] array;
        int point;

        public Pair(int[] array) {
            this.array = array;
            this.point = 0;
        }

        public boolean hanNext() {
            return array.length > point;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,3,5,6,8,11,25};
        int[] b = {5,6,9,14,16,20,21};
        int[] c = {2,4,7,9,11,21,31,51};
        int[] d = {10,22,23,31,34,50};

        int[] sort = kMergeSort(a, b, c, d);
        System.out.println(Arrays.toString(sort));
    }
}
