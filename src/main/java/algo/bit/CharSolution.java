package algo.bit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * char类型有关的位运算
 */
public class CharSolution {

  /**
   * 找出只出现一次的数字
   * leetcode 136
   */
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int i : nums) {
      res ^= i;
    }
    return res;
  }

  /**
   * leetcode 389
   * 找出两个字符串中不同的字符
   */
  public char findTheDifference(String s, String t) {
    char result = 0;
    for (char c : s.toCharArray()) {
      result ^= c;
    }

    for (char c : t.toCharArray()) {
      result ^= c;
    }
    return result;
  }

  /**
   * leetcode 409
   * 最长回文子串
   * todo 重要
   */
  public int longestPalindrome(String s) {
    // 仅包含字母，int数组用作计数
    int[] cnt = new int[58];
    for (char c : s.toCharArray()) {
      cnt[c - 'A'] += 1;
    }

    int ans = 0;
    for (int x : cnt) {
      // 每个出现的字符，最多使用偶数次
      // x & 1, 奇数结果为1，偶数为0
      ans += x - (x & 1);
    }

    // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一
    return ans < s.length() ? ans + 1 : ans;
  }
}
