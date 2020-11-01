package algo.hashmap;

import java.util.HashSet;

public class HappyNum {

  /**
   * leetcode 202
   * 快乐数
   */
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();

    while (n != 1) {
      int r = helper(n);
      // 判断是否会产生循环，重复出现
      if (set.contains(r)) return false;
      set.add(r);
      n = r;
    }
    return true;
  }

  private int helper(int n) {
    String s = Integer.toString(n);
    String[] split = s.split("");
    int result = 0;
    for (String s1 : split) {
      result += Integer.parseInt(s1) * Integer.parseInt(s1);
    }
    return result;
  }


}
