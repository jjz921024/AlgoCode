package algo.string;

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

}
