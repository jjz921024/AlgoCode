package algo.bit;

/**
 * leetcode 389
 * 找两个字符串中不同的那个
 */
public class FindTheDifference {

  public char findTheDifference(String s, String t) {
    int result = t.charAt(s.length());
    for (int i = 0; i < s.length(); i++) {
      result += s.charAt(i);
      result -= t.charAt(i);
    }
    return (char) result;
  }

  // 使用异或，相同字符抵消
  public char findTheDifference2(String s, String t) {
    char result = 0;
    for (char c : s.toCharArray()) {
      result ^= c;
    }

    for (char c : t.toCharArray()) {
      result ^= c;
    }
    return result;
  }

}
