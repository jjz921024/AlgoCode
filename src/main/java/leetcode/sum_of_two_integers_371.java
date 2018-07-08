package leetcode;

/**
 * Created by Jun on 2018/7/8.
 */
public class sum_of_two_integers_371 {
    public int getSum(int a, int b) {
        int xorSum = a ^ b;
        int tmp = a | b;
        return xorSum | tmp<<1;
    }
}
