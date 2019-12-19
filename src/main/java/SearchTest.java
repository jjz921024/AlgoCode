import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import search.BinarySearch;
import search.InterpolationSearch;
import sort.QuickSort;
import utils.sort.SortUtil;

public class SearchTest {

    private SortUtil sortUtil;
    private int[] data;

    @Before
    public void init() {
        sortUtil = new SortUtil(10000);
        data = sortUtil.getData();
        QuickSort.quickSort(data, 0, data.length - 1);
    }

    @Test
    public void testBinarySearch() {
        Assert.assertTrue(SortUtil.isSorted(data));
        BinarySearch.binarySearch(data, 10000);

        BinarySearch.binarySearch(data, -1);

        BinarySearch.binarySearch(data, 500);
    }

    @Test
    public void testInterpolationSearch() {
        Assert.assertTrue(SortUtil.isSorted(data));
        InterpolationSearch.search(data, 999);

    }
}
