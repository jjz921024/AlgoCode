package algo.bit;

import java.util.HashSet;

/**
 * Created by Jun on 2017/8/18.
 */
public class NumSolution {

  /**
   * 判断一个整数是否是2的平方
   */
  public boolean isPowerOf2(int number) {
    return number > 0 && (number & number - 1) == 0;
  }

  /**
   * leetcode 342
   * 4的幂， 即为2的幂的平方
   * 先判断是否为2的幂，再分 2的偶次幂和奇次幂 （二进制都只有1个1）
   * 2的偶次幂，1在偶数下标位置上；2的奇次幂，1在奇数位置上
   */
  public boolean isPowerOfFour(int num) {
    return num > 0 && ((num & num - 1) == 0) && ((num & 0xaaaaaaaa) == 0);
  }

  /**
   * 倒序32位无符号整数
   * leetcode 190
   */
  public int reverseBits(int n) {
    int result = 0;
    // 不能使用while(n != 0) 有前导零的情况
    for (int i = 0; i < 31; i++) {
      result <<= 1;  // 先移位
      if ((n & 0x01) == 1) {
        result |= 0x01;
      }
      n >>= 1;
    }
    return result;
  }

  /**
   * 返回一个正整数转换成二进制后 数字1的个数
   * <p>
   * Integer.bitCount(number)
   */
  public int numOfOne(int number) {
    int count = 0;
    while (number != 0) {
      count++;
      number &= number - 1;
      // number -= number & (~number + 1);
    }
    return count;
  }

  /**
   * leetcode 371
   * 不用 + - 做加减运算
   */
  public int getSum(int a, int b) {
    while (b != 0) {
      int add = a ^ b;
      b = (a & b) << 1;
      a = add;
    }
    return a;
  }

  /**
   * leetcode 461
   * 汉明距离
   */
  public int hammingDistance(int x, int y) {
    int temp = x ^ y;
    int dis = 0;
    while (temp != 0) {
      // 对2取余，判断末尾是不是1
      if (temp % 2 == 1)
        dis++;
      temp >>= 1;
    }
    return dis;
  }

  /**
   * leetcode 268
   * 缺失的数字
   */
  public int missingNumber(int[] nums) {
    // 序列 0..n  数组下标0..n-1
    // 先补全n
    int result = nums.length;
    // 数组下标 异或 值
    for(int i = 0; i < nums.length; i++) {
      result ^= nums[i] ^ i;
    }
    return result;
  }

  /**
   * leetcode 645
   * 第268题进阶
   */
  public int[] findErrorNums(int[] nums) {
    int[] result = new int[2];

    int total = 0;
    for(int i = 1; i <= nums.length; i++) {
      total ^= i;
    }

    HashSet<Integer> set = new HashSet<>();
    for(int i : nums) {
      if(set.contains(i)) {
        result[0] = i;
      } else {
        set.add(i);
        total ^= i;
      }
    }
    result[1] = total;
    return result;
  }


  ////////////////////////////////////////////////////

  // todo 
  public boolean hasAlternatingBits(int n) {
    return (n ^ n >> 1) == 0xffffffff;
  }
}
