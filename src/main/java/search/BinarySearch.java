package search;

/**
 * 二分查找 / 折半查找
 * 在数组中查找指定值的元素，返回元素所在数组下标。未找到返回-1
 */
@SuppressWarnings("Duplicates")
public class BinarySearch {

    /**
     * 1. 因为搜索区间上界使用array.length-1, 相当于[low, high]闭区间
     *    while(low <= high)的终止条件是low == high + 1, 即[high + 1, high]
     *    区间为空退出循环
     * 2. 确定下一步的搜索区间时，high/low = mid - 1，因为mid已经搜索过，应该从区间中剔除
     */
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

    /**
     * 二分搜索的另一种实现
     * 当数组存在重复元素时，能找到目标第一次/最后一次出现的位置
     */
    public static int binarySearchLeft(int[] array, int target) {
        int left = 0, right = array.length - 1;
        // 退出循环时，终止条件是[left, left]，留有left未搜索
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                // 找到目标值时，收缩右边界
                right = mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }

        // 得到left后，因为找目标的左边界，做如下判断
        if (left == array.length) return -1; // left在最右边，表示没有目标值
        return array[left] == target ? left : -1;
    }

    // 搜索目标值的右边界
    public static int binarySearchRight(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        if (right == 0) return -1;
        return array[right] == target ? right : -1;
    }

}
