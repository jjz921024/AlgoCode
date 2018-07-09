package leetcode;

import java.util.Stack;

/**
 * Created by Jun on 2018/7/9.
 */
public class L682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                Integer last = stack.pop();
                int sum = last + stack.peek();
                stack.push(last);
                stack.push(sum);
            } else if (s.equals("D")) {
                int sum = stack.peek() * 2;
                stack.push(sum);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
