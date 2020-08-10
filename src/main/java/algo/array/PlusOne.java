package algo.array;

public class PlusOne {

  /**
   * leetcode 66
   * 整数数组加一
   */
  public int[] plusOne(int[] digits) {
    for(int i = digits.length - 1; i >= 0; i--) {
      if(digits[i] + 1 >= 10) {
        digits[i] = 0;
      } else {
        digits[i] += 1;
        return digits;
      }
    }

    // 若是能执行完for循环，一定是999..9 + 1
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

}
