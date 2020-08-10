package algo.list;

import utils.ListNode;
import utils.Node;

public class ReverseList {

  /**
   * leetcode 206 反转链表
   * 迭代方式
   */
  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;  // 翻转，当前头节点的next改成指向前一个节点prev
      prev = head;  // 往下走
      head = next;
    }
    return prev;
  }

  // 递归翻转链表
  public Node reverse2(Node node) {
    if (node.next == null) {
      return node;
    }

    // 先翻转node结点之后的链表
    Node newHead = reverse2(node.next);

    // 再把原 node 节点后继结点的后继结点指向 node，node 的后继节点设置为空(防止形成环)
    node.next.next = node;
    node.next = null;

    // 返回翻转后的头结点
    return newHead;
  }


  /**
   * 翻转位置从from到to的结点（从1开始计）
   * todo
   */
  public static ListNode reversePartList(ListNode head, int from, int to) {
    if (head == null || head.next == null) return head;
    if (from >= to) return head;

    ListNode cur = head;
    ListNode prev = null;

    ListNode start = head;
    ListNode end = null;

    for (int i = 1; i < from; i++) {
      cur = cur.next;
    }

    // 翻转链表
    for (int i = from; i <= to; i++) {

    }

    // 从头节点开始翻转的情况
    if (from == 1) {

    }
    return head;
  }


  /**
   * leetcode 24 两两交换链表中相邻节点  (2个一组反转链表)
   *
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode n1 = head;
    ListNode n2 = head.next;

    // 翻转剩余部分，返回的节点拼接在n1后
    n1.next = swapPairs(n2.next);  // !!!

    n2.next = n1;
    return n2;
  }
}
