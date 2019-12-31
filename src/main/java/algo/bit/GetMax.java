package algo.bit;

/**
 * Created by Jun on 2017/8/29.
 * 不用任何比较判断找出两个数中较大的数
 */
public class GetMax {

    /**
     * 判断 a-b 的符号
     * 缺陷：当a为正数，b为负数时，有可能产生溢出
     */
    public static int getMax(int a, int b) {
        int c = a-b;
        int scA = sign(c);  //若c为1，说明a大； c为0，说明b大
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    // 最高位为1返回0，最高位为0返回1
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    // 翻转0和1
    static int flip(int n) {
        return n ^ 1;
    }

    /**
     * 方法二: 若a,b异号，则返回正数
     */
    public static int getMax2(int a, int b) {
        int sa = sign(a);
        int sb = sign(b);
        int diff = sa ^ sb;  // a,b符号相同为0，不同为1
        if (diff == 0)
            return getMax(a, b);
        else
            return a * sa + b * sb;
    }


    public static void main(String[] args) {
        System.out.println(getMax2(-1000000000, 11111115));
    }
}
