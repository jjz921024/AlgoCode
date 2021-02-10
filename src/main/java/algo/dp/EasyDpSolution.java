package algo.dp;

public class EasyDpSolution {

  /**
   * leetcode 70 爬楼梯
   */
  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;  // 0阶楼梯也算一种
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // 三步问题 todo
  public int waysToStep(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[n] % 1000000007;
  }
}
