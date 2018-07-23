package leetcode;

/**
 * Created by Jun on 2018/7/23.
 */
public class L788_RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i=1; i<=N; i++) {
            char[] chars = Integer.toString(i).toCharArray();
            for (char c : chars) {
                if (c == '3' || c == '4' || c == '7')
                    break;
                else if (c == '2' || c == '5' || c == '6' || c == '9')
                    count++;
            }
        }
        return count;
    }
}
