package leetcode.algo.bit;

/**
 * Created by Jun on 2017/8/18.
 */
public class BitOperate {
    /**
     * 判断一个整数是否是2的平方
     */
    public static boolean isPowerOf2(int number) {
        return (number & number - 1) == 0;
    }

    /**
     * 返回一个正整数转换成二进制后 数字1 的个数
     * 循环次数只与1的个数有关
     */
    public static int numOfOne(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number &= number-1;
            //todo: number -= number & (~number + 1);
        }
        return count;
        //return Integer.bitCount(number);
    }

    public static void main(String[] args) {
        System.out.println(numOfOne(3));
    }
}
