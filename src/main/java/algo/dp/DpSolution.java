package algo.dp;

public class DpSolution {

  /**
   * 高楼抛鸡蛋 leetcode 887
   * K个鸡蛋，N层楼，最坏情况下，你至少要扔几次鸡蛋，才能确定鸡蛋恰好摔不碎的楼层
   *
   * 最坏情况：鸡蛋碎不碎，取决于哪种情况下可以尝试的次数更多
   * 至少：无论哪种最坏情况下，至少要扔鸡蛋的次数
   */
  public int superEggDrop(int K, int N) {
    int[][] dp = new int[K + 1][N + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        dp[i][j] = -1;
      }
    }
    return helper2(K, N, dp);
  }

  // 普通的状态搜索
  private int helper2(int K, int N, int[][] dp) {
    // base case
    if (K == 1) return N; // 只剩一个鸡蛋时，至少还要尝试N次才能最终确定楼层
    if (N == 0) return 0; // 需搜索楼层数为0时

    if (dp[K][N] != -1) return dp[K][N];

    int result = Integer.MAX_VALUE;
    // 穷举每个楼层[1, N]，每次选择尝试次数最少的那一层
    for (int i = 1; i < N + 1; i++) {
      // 碎, 鸡蛋减1, 搜索楼层变为[1, i-1],总i-1楼
      int r1 = helper2(K - 1, i - 1, dp);
      dp[K - 1][i - 1] = r1;

      // 没碎, 鸡蛋不变，搜索楼层变为[i+1, N]，总N-i楼
      int r2 = helper2(K, N - i, dp);
      dp[K][N - i] = r2;

      // 不管鸡蛋碎没碎，取决于哪种情况下尝试次数更多 （求最坏情况）
      result = Math.min(result, Math.max(r1, r2) + 1);
      dp[K][N] = result;
    }
    return result;
  }

  // 二分搜索优化的状态查找
  // dp函数关于N的单调递增
  private int helper3(int K, int N, int[][] dp) {
    if (K == 1) return N;
    if (N == 0) return 0;

    if (dp[K][N] != -1) return dp[K][N];
    int result = Integer.MAX_VALUE;

    int low = 1;
    int high = N;
    while (low <= high) {
      int mid = (low + high) / 2;
      // 假设碎的情况，dp函数关于mid-1递增
      int broken = helper3(K - 1, mid - 1, dp);
      // 假设没碎，dp函数关于N-mid递减
      int notBroken = helper3(K, N - mid, dp);

      // 求至少扔的次数，求最大的返回值 todo
      if (broken > notBroken) {
        // 若broken大，由于递增，当前楼层碎了，则只继续向下搜索
        high = mid - 1;
        result = Math.min(result, broken + 1);
      } else {
        low = mid + 1;
        result = Math.min(result, notBroken + 1);
      }
      dp[K][N] = result;
    }

    return result;
  }

}
