package algo.stack;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/16.
 * 用2个栈实现一个队列，实现队列的add、poll、peek操作
 *
 *  1、push栈必须一次性将数据倒入pop栈
 *  2、pop栈必须为空时才能进行倒入
 *
 *  入队的时间复杂度为O(1), 出队的均摊时间复杂度为O(1)
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    // 入队操作
    public void enqueue(int a) {
        stackPush.push(a);
    }

    // 出队操作
    public Integer dequeue() {
        if (stackPop.isEmpty()) {
            if (stackPush.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackPop.pop();
    }

    // 将push栈的元素转移到pop栈
    private void transfer() {
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }
}
