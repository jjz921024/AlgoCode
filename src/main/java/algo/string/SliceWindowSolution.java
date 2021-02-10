package algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SliceWindowSolution {

  /**
   * leetcode 76 最小覆盖子串
   * todo review
   */
  public String minWindow(String s, String t) {
    // 统计子串中字符个数
    HashMap<Character, Integer> needMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      needMap.put(c, needMap.getOrDefault(c, 0) + 1);
    }

    char[] chars = s.toCharArray();
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int matchCount = 0;
    int start = 0, len = Integer.MAX_VALUE;  // 最后子串在父串的偏移和长度

    while (right < s.length()) {  // 滑动窗口遍历完字符串
      char c = chars[right];
      right++;  // 右移窗口

      // 判断是否是子串中的字符
      if (needMap.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 窗口中的字符是否满足需要
        if (window.get(c).equals(needMap.get(c))) {  // Integer比较不能用 ==，除非 -128到128 缓存
          matchCount++;
        }
      }

      // 窗口是否要收缩的条件， 在可行解的基础上寻找最优解
      while (matchCount == needMap.size()) {
        // 更新最优解
        if (right - left < len) {
          start = left;
          len = right - left;
        }

        char removeChar = chars[left];
        left++;

        // 注意顺序，与上面相反
        if (needMap.containsKey(removeChar)) {
          if (window.get(removeChar).equals(needMap.get(removeChar))) {
            matchCount--;
          }
          window.put(removeChar, window.get(removeChar) - 1);
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }

  /**
   * leetcode 567
   * 判断 s2 是否包含 s1 的排列
   */
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> needMap = new HashMap<>();
    for (char c : s1.toCharArray()) {
      needMap.put(c, needMap.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    char[] chars = s2.toCharArray();
    HashMap<Character, Integer> window = new HashMap<>();
    int matchCount = 0;

    while (right < s2.length()) {
      char c = chars[right];
      right++;

      if (needMap.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (needMap.get(c).equals(window.get(c))) {
          matchCount++;
        }
      }

      while (right - left >= s1.length()) {  // 窗口收缩条件，保证窗内大小为s1的长度
        if (matchCount == needMap.size()) { // 判断结果是否达成
          return true;
        }

        char removeChar = chars[left];
        left++;

        if (needMap.containsKey(removeChar)) {
          if (window.get(removeChar).equals(needMap.get(removeChar))) {
            matchCount--;
          }
          window.put(removeChar, window.get(removeChar) - 1);
        }

      }
    }
    return false;
  }


  /**
   * leetcode 438 找出所有的字母异位词
   */
  public List<Integer> findAnagrams(String s, String p) {
    if (s == null || "".equals(s)) return new ArrayList<>();

    HashMap<Character, Integer> needMap = new HashMap<>();
    for (char c : p.toCharArray()) {
      needMap.put(c, needMap.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    HashMap<Character, Integer> window = new HashMap<>();
    int matchCount = 0;
    char[] chars = s.toCharArray();
    ArrayList<Integer> result = new ArrayList<>();

    while (right < s.length()) {
      char c = chars[right];
      right++;

      if (needMap.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(needMap.get(c))) {
          matchCount++;
        }
      }

      while (right - left >= p.length()) {
        if (matchCount == needMap.size()) {
          result.add(left);
        }

        char removeChar = chars[left];
        left++;

        if (needMap.containsKey(removeChar)) {
          if (window.get(removeChar).equals(needMap.get(removeChar))) {
            matchCount--;
          }
          window.put(removeChar, window.get(removeChar) - 1);
        }
      }
    }

    return result;
  }

  /**
   * leetcode 3 最长无重复子串
   */
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int max = 0;
    char[] chars = s.toCharArray();

    while (right < s.length()) {
      char c = chars[right];
      right++;

      window.put(c, window.getOrDefault(c, 0) + 1);

      // 窗口内有重复元素
      // 收缩窗口直到没有元素重复
      while (window.get(c) > 1) {
        char removeChar = chars[left];
        left++;
        window.put(removeChar, window.get(removeChar) - 1);
      }

      // 窗口变化结束后更新max
      // 不能用map.size()  删除元素是以value是否为0判断 k -> 0
      max = Math.max(max, right - left);
    }
    return max;
  }



}
