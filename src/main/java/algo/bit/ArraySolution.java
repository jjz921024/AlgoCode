package algo.bit;

public class ArraySolution {

  /**
   * leetcode 1460
   * 本质是 判断两个数组是否一样
   * 两个数组的 和 异或 都一样即各个元素一样
   */
  public boolean canBeEqual(int[] target, int[] arr) {
    int sum1 = 0, sum2 = 0;
    int xor1 = 0, xor2 = 0;
    for(int i=0; i<arr.length; i++) {
      sum1 += arr[i];
      sum2 += target[i];
      xor1 ^= arr[i];
      xor2 ^= target[i];
    }
    return (sum1 == sum2) && (xor1 == xor2);
  }
}
