package algo.list;

import utils.ListNode;

/**
 * leetcode 61
 * 旋转链表
 */
public class RotateList {

  // 向左移动k个位置
  public ListNode rotateLeft(ListNode head, int k) {
    if (head == null) return null;
    if (head.next == null) return head;

    ListNode h = head;
    ListNode prev = null;

    while (k-- > 0) {
      prev = h;
      if (h == null) {
        h = head;
      }
      h = h.next;
    }

    ListNode result = h;
    if (h != head) {
      while (h.next != null) {
        h = h.next;
      }
      h.next = prev;
      prev.next = null;
    }

    return result;
  }

  // 向右移动k个位置
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    if (head.next == null) return head;

    // 将链表连成环
    ListNode cur = head;
    int len = 0;
    while (cur.next != null) {
      cur = cur.next;
      len++;
    }
    cur.next = head;

    cur = head;
    k = len - k % len - 1;
    while(k-- > 0) {
      cur = cur.next;
    }
    ListNode res = cur.next;
    cur.next = null;
    return res;
  }
}
