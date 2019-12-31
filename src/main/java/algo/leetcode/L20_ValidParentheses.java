package algo.leetcode;

import java.util.Stack;

/**
 * Created by Jun on 2018/7/9.
 */
public class L20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char tmp = stack.peek();
                    if (tmp ==  '(' && c == ')'
                            || tmp ==  '[' && c == ']'
                            || tmp ==  '{' && c == '}')
                        stack.pop();
                    else
                        return false;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
