package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 对元素划分区间访问，对每个分区的元素进行排序
 * 每个桶的区间跨度 = （最大值 - 最小值） / （桶的数量 - 1）
 * <p>
 * 时间复杂度：O(n) 遍历n个元素，运算量为n； 当元素分布不均匀时，退化为O(nlogn)
 * 空间复杂度: O(n)
 * 稳定性：稳定 (取决于桶内排序的算法)
 */
public class BucketSort {

    public static void bucketSort(int[] array, int bucketNum) {
        // 找出最大最小值，计算区间范围
        double min = array[0];
        double max = array[0];
        for (double i : array) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        double d = max - min;

        // 初始化桶, 用list维护桶的顺序，LinkedList维护桶内的元素  类似HashMap的结构
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i<bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 将所有元素放入对应的桶内
        // 向下取整 (i - min) / 跨度 = 对应桶的下标
        for (int i : array) {
            int num = (int) ((i - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(i);
        }

        // 对每个桶内排序, Collections的底层是归并或TimSort，当作复杂度为O(nlogn)
        for (LinkedList<Integer> bucket : bucketList) {
            Collections.sort(bucket);
        }

        // 输出
        int idx = 0;
        for (LinkedList<Integer> bucket : bucketList) {
            for (int i : bucket) {
                array[idx++] = i;
            }
        }
    }

}
