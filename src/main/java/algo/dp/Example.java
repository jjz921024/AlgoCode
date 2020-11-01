package algo.dp;

import java.util.HashMap;

public class Example {

    public int normalFib(int i) {
        if (i <= 2) return 1;
        return normalFib(i - 1) + normalFib(i - 2);
    }


    // -------------
    // 自顶向下
    private HashMap<Integer, Integer> dpTab = new HashMap<>();

    public int dpFib(int i) {
        if (i <= 2) return 1;
        if (dpTab.get(i) != null) return dpTab.get(i);

        int result = dpFib(i - 1) + dpFib(i - 2);
        dpTab.put(i, result);
        return result;
    }


    // -------------
    // 自底向上，事先构建dp table
    public int dpFib2(int i) {
        int[] dp = new int[i + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int j = 3; j <= i; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[i];
    }



}
