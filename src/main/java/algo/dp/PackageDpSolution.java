package algo.dp;

import java.util.HashMap;

/**
 * 背包问题相关
 */
public class PackageDpSolution {

  /**
   * 0-1背包问题
   * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性
   * 其中第i个物品的重量为wt[i]，价值为val[i]
   * 现在让你用这个背包装物品，最多能装的价值是多少
   *
   * dp[i][j]: 对于前i个物品进行选择，当背包容量为w时，可以装下的最大价值为dp[i][j]
   */
  int knapsack(int W, int N, int[] wt, int[] val) {
    int[][] dp = new int[N + 1][W + 1];

    // base case
    // int[0][...] 没有物品时
    // int[...][0]背包没有空间时  最大价格都为0

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= W; j++) {
        if (j - wt[i - 1] < 0) {
          // 当前背包容量装不下，只能选择不装入背包
          // 最大价值不变
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(
              dp[i - 1][j - wt[i - 1]] + val[i - 1], // 装入
              dp[i - 1][j]);  // 不装入
        }
      }
    }
    return dp[N][W];
  }

  /**
   * leetcode 416 分割等和子集
   * 转换为背包问题解决
   *
   * 可载重力为sum/2的背包和N个物品，每个物品重量nums[i]
   * 问是否有一种装法，能够恰好装满背包
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) return false;  // 和为奇数时不可能等分

    boolean[][] dp = new boolean[nums.length + 1][sum + 1];
    // base case
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j < sum / 2 + 1; j++) { // 只需算到sum/2
        if (j - nums[i - 1] < 0) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }

    return dp[nums.length][sum / 2];
  }

  /**
   * leetcode 322
   * 凑硬币  求至少需要几枚才能凑出指定金额
   */
  public int coinChange(int[] coins, int amount) {
    HashMap<Integer, Integer> dp = new HashMap<>();
    return helper(coins, amount, dp);
  }

  private int helper(int[] coins, int amount, HashMap<Integer, Integer> dp) {
    if (amount == 0) return 0;
    if (amount < 0) return -1;

    // 求最小值，初始化最大
    int result = Integer.MAX_VALUE;
    for (int coin : coins) {
      Integer i = dp.get(amount - coin);
      if (i == null) {
        i = helper(coins, amount - coin, dp);
        dp.put(amount - coin, i);
      }

      // 金额超限的情况
      if (i == -1) continue;
      result = Math.min(result, 1 + i);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
