package algo.stack;

import java.util.Stack;

/**
 * 括号匹配
 * '('，')'
 * '{'，'}'
 * '['，']'
 */
public class VaildParentheses {

  public boolean isValid(String s) {
    if (s == null || "".equals(s)) {
      return true;
    }

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.add(c);
      } else {
        // 栈已空，但还有右括号
        if (stack.isEmpty()) {
          return false;
        }

        // 逐种括号匹配
        Character pop = stack.pop();
        if (c == ')' && pop != '(') {
          return false;
        } else if (c == '}' && pop != '{') {
          return false;
        } else if (c == ']' && pop != '[') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
