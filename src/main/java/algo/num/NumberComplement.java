package algo.num;

/**
 * leetcode 476
 * 求整数的补数，二进制取反 （不是补码）
 */
public class NumberComplement {

    // 利用异或取反
    public int findComplement(int num) {
        // 求num的位数
        long n = 1;  // 2147483647 异或的数要比int大，防止溢出
        while (n <= num) {  // 注意等号
            n <<= 1;
        }

        n -= 1;  // 例如 100 变成 011

        return (int) n ^ num;
    }
}
