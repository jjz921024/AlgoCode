package algo.string;

public class PalindromicSolution {

  /**
   * 字符串是否是回文
   */
  public static boolean isPalindrome(String text) {
    int length = text.length();
    for (int i = 0; i < length / 2; i++) {
      if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * leetcode 680
   * 最多可删除一个字符的情况下，验证字符串是否回文
   * 注意：有字符不相等，但删除左右两边都可继续验证时，要都判断
   */
  public boolean validPalindrome(String s) {
    int p1 = 0, p2 = s.length() - 1;
    while (p1 <= p2) {
      if (s.charAt(p1) != s.charAt(p2)) {
        return isPalindrome(s, p1 + 1, p2) || isPalindrome(s, p1, p2 - 1);
      }
      p1 += 1;
      p2 -= 1;
    }
    return true;
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start += 1;
      end -= 1;
    }
    return true;
  }

  /**
   * leetcode 647
   * 回文子串个数
   * 找中心点(2*len-1)个，往外扩散
   */
  public int countSubstrings(String s) {
    int cnt = 0;
    int len = s.length();
    // 重点：有2*len-1个中心的，考虑奇数和偶数的情况
    for(int i=0; i< 2*len-1; i++) {
      // 注意left和right的取值
      int left = i / 2;
      int right = left + i % 2;
      while(left>=0 && right<len && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
        cnt++;
      }
    }
    return cnt;
  }

  // 方法二 动态规划
  public int countSubstrings2(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int ans = 0;

    // 画二维数组得dp遍历方向
    for (int i=0; i<s.length(); i++) {
      for(int j=0; j<=i; j++) {
        // i-j<2 即表示区间[i,j]构成的子串只有一个字符或空字符，此时当然为回文串
        // s.charAt(i)==s.charAt(j)首尾字符相等 且 dp[i-1][j+1]去掉首尾后也为回文串，即[i,j]也构成回文串
        if (s.charAt(i) == s.charAt(j) && (i-j<2 || dp[i-1][j+1])) {
          dp[i][j] = true;
          ans++;
        }
      }
    }
    return ans;
  }

  /**
   * leetcode 5
   * 最长回文子串
   * 对比 {@link algo.dp.ArrayDpSolution#longestPalindromeSubseq} 求最长回文子序列的长度
   *
   */
  public String longestPalindrome(String s) {
    if(s == null || "".equals(s) || s.length() < 2) return s;

    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    char[] ch = s.toCharArray();

    for(int i=0; i<len; i++) {
      dp[i][i] = true;
    }

    int begin = 0;
    int maxLen = 1;

    // dp遍历方向一致
    for(int i=len-2; i>=0; i--) {
      for(int j=i+1; j<len; j++) {
        if(ch[i] != ch[j]) {
          dp[i][j] = false;
        } else {
          // 双闭区间 [i+1, j-1] 若不构成区间，即 (j-1)-(i+1)<2, 得j-i<3
          // 即当子串 [i,j] 长度等于2或3时， 区间[i+1, j-1]必为回文（空字符或一个字符）
          // 此时只需判断[i,j]的首位字符是否相等即可
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

}
