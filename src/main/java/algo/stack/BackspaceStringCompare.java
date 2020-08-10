package algo.stack;

import java.util.Stack;

/**
 * leetcode 844 比较含有退格的字符是否相等
 * #代表删除前一个字符
 * <p>
 * 或者用StringBuilder实现
 */
public class BackspaceStringCompare {

  public boolean backspaceCompare(String S, String T) {
    Stack<Character> stack1 = new Stack<>();
    for (char c : S.toCharArray()) {
      if (c == '#') {
        if (!stack1.isEmpty())
          stack1.pop();
      } else {
        stack1.push(c);
      }
    }

    Stack<Character> stack2 = new Stack<>();
    for (char c : T.toCharArray()) {
      if (c == '#') {
        if (!stack2.isEmpty())
          stack2.pop();
      } else {
        stack2.push(c);
      }
    }

    return stack1.equals(stack2);
  }
}
