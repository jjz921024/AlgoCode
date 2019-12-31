package algo.leetcode;

/**
 * todo: no finish
 * Created by Jun on 2018/7/8.
 */
public class L371_SumOfTwoIntegers__ {
    public int getSum(int a, int b) {
        int xorSum = a ^ b;
        int tmp = a | b;
        return xorSum | tmp<<1;
    }
}
