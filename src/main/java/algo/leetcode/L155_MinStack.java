package algo.leetcode;

import java.util.Stack;

/**
 * Created by Jun on 2018/7/9.
 */
public class L155_MinStack {

    class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();
        public MinStack() {

        }

        public void push(int x) {
            if (stackMin.isEmpty() || stackMin.peek() >= x) {
                stackMin.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() <= stackMin.peek()) {
                stackMin.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }
}


