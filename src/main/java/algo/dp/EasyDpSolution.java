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

  // 三步爬楼梯问题
  public int waysToStep(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007  + dp[i - 3]) % 1000000007;
    }
    return dp[n];
  }

  /**
   * leetcode 62
   * 只能往右或往下走的不同路径
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    // 边界，当只有一行或一列时，只有一条路径可走
    for(int i=0; i<m; i++) dp[i][0] = 1;
    for(int i=0; i<n; i++) dp[0][i] = 1;

    for(int i=1; i<m; i++) {
      for(int j=1; j<n; j++) {
        // 走到(i,j)的路径数等于 (i-1,j)和(i,j-1)之和
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }

    return dp[m-1][n-1];
  }
}
