package algo.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Jun on 2017/8/16.
 * 一个有返回最小值的栈
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * push时判断minstack栈顶元素是否小于a，维持minstack栈顶元素最小
     */
    public void push(int a) {
        if (stackMin.isEmpty() || a < stackMin.peek()) {
            stackMin.push(a);
        }
        this.stack.push(a);
    }

    public Integer pop() {
        if (stack.peek().equals(stackMin.peek())) {
            stackMin.pop();
        }
        return stack.pop();
    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stackMin.peek();
    }
}
