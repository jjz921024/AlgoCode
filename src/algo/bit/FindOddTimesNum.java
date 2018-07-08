package algo.bit;

/**
 * Created by Jun on 2017/8/29.
 * 在其他数都出现偶数次的数组中找到只出现奇数次的数
 */
public class FindOddTimesNum {

    /**
     * 只有一个数出现奇数次，其他数都只出现偶数次
     */
    public static int findOddTimesNumOnly(int[] arr) {
        int res = 0;
        for (int a : arr) {
            res ^= a;
        }
        return res;
    }

    /**
     * 有两个数出现奇数次，其他数都只出现偶数次
     */
    public static void findOddTimesNumTwo(int[] arr) {
        int e = 0;
        for (int a : arr) {
            e ^= a;
        }

        int rightOne = e & (~e + 1); // 找出e的最右边的1所在的位数
        int eHasOne = 0;
        // 只与在第k位上是1的数进行异或
        for (int a : arr) {
            if ((a & rightOne) == 1) {
                eHasOne ^= a;
            }
        }
        System.out.println((e^eHasOne) + " and " + eHasOne);
    }

    public static void main(String[] args) {
        System.out.println(findOddTimesNumOnly(new int[]{1, 1, 5, 5, 6, 6, 3, 3, 2, 6, 6}));
        findOddTimesNumTwo(new int[]{2,4,4,4,4,7,7,7,8,8,9,9,0,0});
    }
}
