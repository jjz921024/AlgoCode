package algo.string;

import java.util.Arrays;
import java.util.List;

public class DoublePointerSolution {

  /**
   * leetcode 524
   * 通过删除字母匹配到字典里最长单词
   */
  public String findLongestWord(String s, List<String> d) {
    char[] t = s.toCharArray();
    String res = "";

    for (String c : d) {
      int j = 0;
      char[] chars = c.toCharArray();

      for (int i = 0; i < t.length && j < chars.length; i++) {
        if (chars[j] == t[i]) {
          j++;
        }
      }

      if (j == c.length() && res.length() <= c.length()) {
        if (res.length() == c.length()) {
          for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) > c.charAt(i)) {
              res = c;
              break;
            } else if (res.charAt(i) < c.charAt(i)) {
              break;
            }
          }
        } else {
          res = c;
        }
      }
    }

    return res;
  }

  // 方法二：先判断是否是子串，字典序用compareTo函数
  public String findLongestWord2(String s, List<String> d) {
    String res = "";
    for (String s1 : d) {
      if (isSubsequence(s1, s)) {
        if (res.length() < s1.length() || (res.length() == s1.length() && res.compareTo(s1) > 0)) {
          res = s1;
        }
      }
    }
    return res;
  }

  // 判断s是否是t的子串
  private boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == s.length();
  }

}
