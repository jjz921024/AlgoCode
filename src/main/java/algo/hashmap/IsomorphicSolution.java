package algo.hashmap;

import java.util.HashMap;

/**
 * 一一映射
 */
public class IsomorphicSolution {

  /**
   * 同构字符串
   * leetcode 205
   * 方法一: 双向验证
   */
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    return helper(s, t) && helper(t, s);
  }

  private boolean helper(String s, String t) {
    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();

    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < arr1.length; i++) {
      if ((map.containsKey(arr1[i]) && map.get(arr1[i]) != arr2[i])) {
        return false;
      }
      map.put(arr1[i], arr2[i]);
    }
    return true;
  }

  /**
   * 方法二：分情况讨论
   * s[i]在map的key中时，判断map[s[i]]与t[i]
   * s[i]不在map中时，判断t[i]是否存在map的value中
   * todo 重要
   */
  public boolean isIsomorphic2(String s, String t) {
    if (s.length() != t.length()) return false;
    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();

    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < arr1.length; i++) {
      if (map.containsKey(arr1[i])) {
        if (arr2[i] != map.get(arr1[i]))
          return false;
      } else {
        if (map.containsValue(arr2[i]))
          return false;
      }

      map.put(arr1[i], arr2[i]);
    }
    return true;
  }


  /**
   *  leetcode 290
   *  类似上面
   */
  public boolean wordPattern(String pattern, String str) {
    if (str == null) return false;
    if (pattern.length() != str.split(" ").length) return false;

    char[] arr1 = pattern.toCharArray();
    String[] arr2 = str.split(" ");

    HashMap<Character, String> map = new HashMap<>();
    for (int i = 0; i < arr1.length; i++) {
      if (map.containsKey(arr1[i])) {
        if (!map.get(arr1[i]).equals(arr2[i]))
          return false;
      } else {
        if (map.containsValue(arr2[i]))
          return false;
      }

      map.put(arr1[i], arr2[i]);
    }
    return true;
  }

}
