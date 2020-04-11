package algo.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空
 *
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class QueueStack {
  private Queue<Integer> queue;

  public QueueStack() {
    this.queue = new LinkedList<>();
  }

  // 后进的元素要放到队头
  public void push(int x) {
    queue.add(x);
    int size = queue.size();
    // 除x外，全部元素依次出队再入队
    // 循环过后，x在队头
    while (size-- > 1) {
      queue.add(queue.poll());
    }
  }


  public int pop() {
    return queue.remove();
  }

  /** Get the front element. */
  public int peek() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}
