package algo.leetcode;

import java.util.Stack;

/**
 * 或者用StringBuilder实现
 * Created by Jun on 2018/7/9.
 */
public class L844_BackspaceStringCompare {
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
