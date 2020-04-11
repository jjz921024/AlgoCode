package algo.list;

import utils.ListNode;

/**
 * 返回单链表的中间节点，双数返回后一个
 * leetcode 876
 * 快慢指针
 */
public class MiddleNode {
  public ListNode middleNode(ListNode head) {
    ListNode l1 = head;
    ListNode l2 = head;

    while (l2 != null && l2.next != null) {
      l1 = l1.next;
      l2 = l2.next.next;
    }

    return l1;
  }
}
