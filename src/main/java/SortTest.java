import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.*;
import utils.sort.SortUtil;

public class SortTest {

    private SortUtil sortUtil;

    @Before
    public void init() {
        sortUtil = new SortUtil(2048);
    }

    @Test
    public void testBubble() {
        int[] data = sortUtil.getData();
        BubbleSort.bubbleSort1(data);
        Assert.assertTrue(SortUtil.isSorted(data));

        sortUtil.reset();
        Assert.assertFalse(SortUtil.isSorted(data));
        BubbleSort.bubbleSort2(data);
        Assert.assertTrue(SortUtil.isSorted(data));

        sortUtil.reset();
        BubbleSort.bubbleSort3(data);
        Assert.assertTrue(SortUtil.isSorted(data));

        sortUtil.reset();
        BubbleSort.bubbleSort4(data);
        Assert.assertTrue(SortUtil.isSorted(data));
    }


    @Test
    public void testMerge() {
        int[] data = sortUtil.getData();
        Assert.assertFalse(SortUtil.isSorted(data));

        MergeSort.mergeSort(data, 0, data.length - 1);
        Assert.assertTrue(SortUtil.isSorted(data));

        // 多路归并排序 前提需要集合内元素有序
        int[] a = {1, 1, 3, 5, 6, 8, 11, 25};
        int[] b = {5, 6, 9, 14, 16, 20, 21};
        int[] c = {2, 4, 7, 9, 11, 21, 31, 51};
        int[] d = {10, 22, 23, 31, 34, 50};
        int[] sort = MultiMergeSort.kMergeSort(a, b, c, d);
        Assert.assertTrue(SortUtil.isSorted(sort));
    }

    @Test
    public void testCount() {
        int[] data = sortUtil.getData();
        int[] sorted = CountSort.countSort1(data);
        Assert.assertFalse(SortUtil.isSorted(data));
        Assert.assertTrue(SortUtil.isSorted(sorted));

        sortUtil.reset();
        sorted = CountSort.countSort2(data);
        Assert.assertFalse(SortUtil.isSorted(data));
        Assert.assertTrue(SortUtil.isSorted(sorted));
    }


    @Test
    public void testSelection() {
        int i = 5;
        while (i-- > 0) {
            int[] data = sortUtil.getData();
            SelectionSort.selectSort(data);
            Assert.assertTrue(SortUtil.isSorted(data));
        }
    }

    @Test
    public void testInsert() {
        int[] data = sortUtil.getData();
        InsertSort.insertSort(data);
        Assert.assertTrue(SortUtil.isSorted(data));
    }
}
