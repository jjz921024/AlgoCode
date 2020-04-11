package algo.hashmap;

import java.util.HashMap;

/**
 * 字母异位词
 * leetcode 242
 */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      Integer count = map.getOrDefault(c, 0);
      map.put(c, count + 1);
    }

    for (char c : t.toCharArray()) {
      if (!map.containsKey(c)) {
        return false;
      }
      map.put(c, map.get(c) - 1);
    }

    for (int value : map.values()) {
      if (value != 0) {
        return false;
      }
    }

    return true;
  }
}
