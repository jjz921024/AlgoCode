package leetcode;

/**
 * Created by Jun on 2018/7/9.
 */
public class L263_UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        else if (num == 1)
            return true;

        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;

        return num == 1;
    }
}
