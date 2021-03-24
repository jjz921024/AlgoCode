package algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈相关问题
 */
public class NextGreaterSolution {

  /**
   * 下一个更大元素
   * 输入一个数组，返回一个等长数组，对应索引存储着下一个更大元素，如果没有则存-1
   * eg: [2,1,2,4,3],  返回 [4,2,4,-1,-1]
   */
  public int[] nextGreaterElement1(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];

    // 倒着遍历
    for (int i = nums.length - 1; i >= 0; i--) {
      // 重点：若栈顶元素小于当前元素，则被弹出
      // 维护单调栈  栈顶到栈底递增
      while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      // 此时栈顶元素就是 下一个更大值
      res[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[i]);
    }

    return res;
  }


  /**
   * leetcode 496
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // 单调栈
    Stack<Integer> stack = new Stack<>();
    // map中的key是nums2中存在下一个更大值的元素，
    // value是那个下一个更大的值
    Map<Integer, Integer> map = new HashMap<>();

    for(int i : nums2) {
      // 重点：如果栈顶元素小于i，说明nums2的元素有下一个更大元素
      // 则组成kv对放入map
      while(!stack.isEmpty() && stack.peek() < i) {
        map.put(stack.pop(), i);
      }
      stack.push(i);
    }

    int[] res = new int[nums1.length];
    for(int i=0; i<nums1.length; i++) {
      // 在map集合则说明存在下一个更大值，否则不存在-1
      res[i] = map.getOrDefault(nums1[i], -1);
    }
    return res;
  }


  /**
   * leetcode 503
   * 循环数组时的 下一个更大元素
   * 遍历2遍数组，2*nums.length-1
   * 栈中存的是数组的下标
   */
  public int[] nextGreaterElements(int[] nums) {
    int[] res = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for(int i=2*nums.length-1; i>=0; i--) {
      // 保持栈顶是 下一个更大元素的下标
      while(!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
        stack.pop();
      }
      res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
      // 下标
      stack.push(i % nums.length);
    }
    return res;
  }

}
