package algo.string;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Jun on 2017/8/29.
 */
public class StringExercise {

  /**
   * 判断两个字符串是否为变形词
   */
  public static boolean isDeformation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    //共255个字符
    int[] map = new int[256];
    char[] char1 = s1.toCharArray();
    for (char a : char1) {
      map[a]++;
    }

    char[] char2 = s2.toCharArray();
    for (char a : char2) {
      if (map[a]-- == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 删除字符串中连续出现k个0的子串
   */
  public static String removeKZeros(String s, int k) {
    int count = 0;
    int start = -1;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      // 遍历连续的'0'
      if (chars[i] == '0') {
        count++;
        start = start == -1 ? i : start;
      } else {
        //判断这一串联系的'0'长度是否为k
        if (count == k) {
          while (count-- != 0)
            chars[start++] = 0;
        }
        count = 0;
        start = -1;
      }
    }
    //遍历结束时，判断字符串尾的0
    if (count == k) {
      while (count-- != 0)
        chars[start++] = 0;
    }
    return String.valueOf(chars);

  }


  /**
   * 判断两个字符串是否为旋转词
   */
  public static boolean isRotation(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
      return false;
    s1 = s1 + s1;
    return s1.contains(s2);
  }

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


  /*public String findLongestWord(String s, List<String> d) {
    int res = Integer.MAX_VALUE;
    for (String s1 : d) {
      
    }
  }*/
}
