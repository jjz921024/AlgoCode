package algo.stack;

import structure.stack.StackExtend;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/16.
 * 用一个栈对另一个栈进行排序，栈顶到栈底数据由大到小
 */
public class SortStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!helpStack.isEmpty() && cur > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }

        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        StackExtend stackExtend = new StackExtend();
        stackExtend.pushFromRandom(10);
        stackExtend.print();
        sortStackByStack(stackExtend);
        stackExtend.print();
    }
}
