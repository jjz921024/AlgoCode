package algo.leetcode;

/**
 * Created by Jun on 2018/7/23.
 */
public class L657_JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int i=0, j=0;
        for (char c : chars) {
            if (c == 'U')
                j++;
            else if (c == 'D')
                j--;

            if (c == 'L')
                i++;
            if (c == 'R')
                i--;
        }
        return (j == 0 && i == 0);

    }
}
