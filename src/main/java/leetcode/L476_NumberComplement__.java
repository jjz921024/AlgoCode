package leetcode;

/**
 * todo: no finish
 * Created by Jun on 2018/7/9.
 */
public class L476_NumberComplement__ {
    public int findComplement(int num) {
        return ~num & -2^32;
    }
}
