package algo.list;

import utils.ListNode;

import java.util.List;

public class RotateList {


  // 向左移动k个位置
  public ListNode rotateLeft(ListNode head, int k) {
    if (head == null) return null;
    else if (head.next == null) return head;

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

  // 向右移动k个位置 todo
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    else if (head.next == null) return head;

    // 将链表连成环
    ListNode h = head;
    while (h.next != null) {
      h = h.next;
    }
    h.next = head;


    ListNode prev = null;
    while (k-- > 0) {
      prev = head;
      head.next = head;
    }

    prev.next = null;
    return head;

  }
}
