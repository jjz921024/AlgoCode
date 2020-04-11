package algo.bit;

/**
 * 倒序对给定32位无符号整数
 * leetcode 190
 * todo
 */
public class ReverseBits {

  public int reverseBits(int n) {
    char[] chars = Integer.toString(n, 2).toCharArray();
    for (int i = 0; i < chars.length / 2; i++) {
      char c = chars[i];
      chars[i] = chars[chars.length - i - 1];
      chars[chars.length - i - 1] = c;
    }
    return Integer.parseInt(new String(chars), 2);
  }

}
