package algo.num;

import java.util.HashSet;

/**
 * leetcode 788
 * todo
 */
public class RotatedDigits {
  public int rotatedDigits(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      HashSet<Character> set = new HashSet<>();
      for (char c : Integer.toString(i).toCharArray()) {
        set.add(c);
      }

      if (set.contains('3') || set.contains('4') || set.contains('7')) {
          break;
      } else if (set.contains('2') || set.contains('5') || set.contains('6') || set.contains('9')) {
          count++;
          break;
      }
    }

    return count;
  }
}