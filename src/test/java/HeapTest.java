import structure.BinaryHeap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import utils.SortUtil;

import static structure.BinaryHeap.HeapType.MaxHeap;
import static structure.BinaryHeap.HeapType.MinHeap;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
public class HeapTest {

    private static BinaryHeap maxHeap;
    private static BinaryHeap minHeap;

    @BeforeClass
    public static void init() {
        SortUtil sortUtil = new SortUtil(10);
        maxHeap = BinaryHeap.buildMaxHeap(sortUtil.getData());
        System.out.println("大顶堆: " + maxHeap.toString());

        sortUtil = new SortUtil(100);
        minHeap = BinaryHeap.buildMinHeap(sortUtil.getData());
        System.out.println("小顶堆: " + minHeap.toString());
    }

    @Test
    public void testBuild() {
        Assert.assertSame(MaxHeap, maxHeap.getType());
        Assert.assertSame(MinHeap, minHeap.getType());
    }

    @Test
    public void test1Insert() {
        System.out.println("Before insert: " + maxHeap.toString());
        maxHeap.insert(500);
        System.out.println("After insert: " + maxHeap.toString());
        Assert.assertSame(MaxHeap, BinaryHeap.getHeapType(maxHeap.getHeap()));
    }

    @Test
    public void test2Pop() {
        while (maxHeap.hasNext()) {
            System.out.print(maxHeap.pop() + " ");
        }
    }
}
