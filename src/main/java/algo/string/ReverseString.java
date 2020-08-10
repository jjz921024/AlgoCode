package algo.string;

/**
 * Created by Jun on 2018/7/10.
 */
public class ReverseString {

  public String reverseString(String s) {
    if (s == null || "".equals(s))
      return s;
    char[] chars = s.toCharArray();
    char temp;
    for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
      temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
    }
    return new String(chars);
  }

}
