package algo.num;

/**
 * Created by Jun on 2018/7/9.
 * Leetcode 9 判断一个整数是否是回文数
 */
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;

    long revers = 0L;
    long temp = x;
    while (temp != 0) {
      revers = 10 * revers + temp % 10;
      temp = temp / 10;
    }

    return x == revers;
  }

  public boolean isPalindrome2(int x) {
    char[] nums = Integer.toString(x).toCharArray();
    for (int i = 0; i < nums.length / 2; i++) {
      if (nums[i] != nums[nums.length - i - 1]) {
        return false;
      }
    }
    return true;
  }
}