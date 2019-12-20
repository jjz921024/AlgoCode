package search;

/**
 * 二分查找 / 折半查找
 * 在数组中查找指定值的元素，返回元素所在数组下标。未找到返回-1
 */
@SuppressWarnings("Duplicates")
public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int count = 1;
        // 当low=high时是最后一次查找
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("第" + count++ + "次查找: low[" + low + "], high[" + high + "], mid[" + mid + "]");

            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                System.out.println("第" + count + "次查找: 找到[" + target + "]在第[" + mid + "]个位置");
                return mid;
            }
        }
        System.out.println("没找到Target: " + target);
        return -1;
    }

}
