package leetcode.algo.stack;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/16.
 * 一个有返回最小值的栈
 */
public class GetMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public GetMinStack() {
        this.stack = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * push时判断minstack栈顶元素是否小于a，维持minstack栈顶元素最小
     * @param a
     */
    public void push(int a) {
        if (this.stackMin.isEmpty()) {  // TODO: 2017/8/16
            this.stackMin.push(a);
        } else if (a < this.stackMin.peek()) {
            this.stackMin.push(a);
        }
        this.stack.push(a);
    }

    public Object pop() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Integer a = this.stack.pop();
        if (a <= this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return a;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return this.stackMin.peek();
    }
}
