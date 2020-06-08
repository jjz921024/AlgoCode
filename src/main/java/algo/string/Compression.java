package algo.string;

public class Compression {

  public int compress(char[] chars) {
    String result = "";
    char temp;
    for (int i = 0; i < chars.length; i++) {
      temp = chars[i];
      int count = 1;
      while (++i < chars.length && temp == chars[i]) {
        count++;
      }
      if (count != 1) {
        result += Integer.toString(count);
      }
    }
    return result.toCharArray().length;
  }

}
