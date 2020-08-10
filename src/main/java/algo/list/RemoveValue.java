package algo.list;

import utils.ListNode;

import java.util.Stack;

public class RemoveValue {

  /**
   * leetcode 203 删除单链表中指定值的所有节点
   * 方法1：利用栈
   * 从栈连接成链表时是头插
   */
  public ListNode removeElements(ListNode head, int val) {
    Stack<ListNode> stack = new Stack<>();
    // 将不等于val的节点用栈保留下来
    while (head != null) {
      if (head.val != val) {
        stack.push(head);
      }
      head = head.next;
    }
    // 从栈中恢复
    while (!stack.isEmpty()) {
      // 类似于头插
      stack.peek().next = head;
      head = stack.pop();
    }
    return head;
  }


  /**
   * 方法2：遍历直接判断
   * 空间复杂度0(1)
   */
  public ListNode removeElements2(ListNode head, int val) {
    //注意：先找第一个不等于a的节点作为头节点
    while (head != null) {
      if (head.val != val)
        break;
      head = head.next;
    }
    ListNode pre = head;
    ListNode cur = head;  // 最好不要Node cur = head.next; 1个节点时会有空指针
    while (cur != null) {
      if (cur.val == val)
        pre.next = cur.next;
      else
        pre = cur;   // 不要pre=pre.next
      cur = cur.next;
    }
    return head;
  }


  /**
   * 删除链表中的节点，非末尾节点
   * leetcode 237
   *
   * @param node 表示的是要删除的结点，保证不是末尾节点
   */
  public void deleteNode(ListNode node) {
    // 因为无法访问前一个结点，所以把要删除的结点的后一个结点的值前移
    node.val = node.next.val;
    // 然后删除掉后一个结点
    node.next = node.next.next;
  }
}
