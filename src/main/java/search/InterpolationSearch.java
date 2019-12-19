package search;

/**
 * 插值查找
 * 基于二分查找算法，将查找点的选择改进为自适应选择
 * 查找点选择公式： mid = low + [(key-a[low]) / (a[high]-a[low]) * (high-low)]
 */
@SuppressWarnings("Duplicates")
public class InterpolationSearch {

    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int count = 1;
        while (low <= high) {
            // 这里先乘再除，避免精度丢失
            int mid = low + (target - array[low]) * (high - low) / (array[high] - array[low]);
            // 判断是否下标越界
            if (mid > high || mid < low) {
                break;
            }
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                System.out.println("第" + count + "次查找: 找到[" + target + "]在第[" + mid + "]个位置");
                return mid;
            }
            System.out.println("第" + count++ + "次查找: low[" + low + "], high[" + high + "], mid[" + mid + "]");
        }
        System.out.println("第" + count + "次查找: 没找到");
        return - 1;
    }

}
