package algo.dp;

/**
 * 字符串子序列相关的动态规划问题
 */
public class ArrayDpSolution {


  /**
   * 涉及一维dp数组的情况
   * dp[i]可以由dp[0...i-1]推出
   *
   * leetcode 300 最长上升子序列
   * dp数组的定义：dp[i]表示以nums[i]结尾的最长递增子序列的长度
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
    }

    // 计算以num[i]结尾的LIS长度
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        // 当前值i比前面的值小，有可能组成最长子序列
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int result = 0;
    for (int i : dp) {
      if (i > result) {
        result = i;
      }
    }
    return result;
  }

  /**
   * leetcode 53 最大子数组和
   *
   * dp数组定义：以nums[i]结尾的最大子数组和为dp[i]
   * 注意与 最长递增子序列的dp数组定义 做对比
   */
  public int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (dp[i - 1] + nums[i] > nums[i]) {
        dp[i] = dp[i - 1] + nums[i];
      } else {
        dp[i] = nums[i];
      }
      // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    }

    int result = Integer.MIN_VALUE;
    for (int i : dp) {
      result = Math.max(result, i);
    }
    return result;
  }



  /**
   * 涉及二维dp数组的情况
   *
   * leetcode 1143 最长公共子序列
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {

        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i + 1][j + 1] = 1 + dp[i][j];
        } else {
          // dp[i][j]的值，取决于它左侧或上侧的最大值
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }

      }
    }

    return dp[text1.length()][text2.length()];
  }


  /**
   * leetcode 72 编辑距离
   */
  public int minDistance(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    // init base case
    for (int i = 1; i <= s1.length(); i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= s2.length(); i++) {
      dp[0][i] = i;
    }

    // 偏1位，从1开始，自底向上，从base case填dp table
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          // 相等时不用编辑
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // dp[i][j]取决于它左、左上、上侧的值
          dp[i][j] = Math.min(dp[i - 1][j] + 1,
              Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }


  /**
   * leetcode 516 求最长回文子序列的长度
   */
  public int longestPalindromeSubseq(String s) {
    int[][] dp = new int[s.length()][s.length()];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == j) dp[i][j] = 1;
      }
    }

    // 遍历顺序是画dp table推出来的
    // 从下往上，从左往右遍历
    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = i + 1; j < dp[i].length; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          // 这步相当于 把左右两个字符分别加入子序列num[i+1...j-1]中，判断谁更长
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][s.length() - 1];
  }


}
