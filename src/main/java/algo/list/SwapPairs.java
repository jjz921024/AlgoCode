package algo.list;

import utils.ListNode;

/**
 * 两两交换链表中相邻节点
 * leetcode 24
 * todo
 */
public class SwapPairs {

  public ListNode swapPairs(ListNode head) {
    if (head == null) return null;

    ListNode result = null, temp = null;
    while (head != null) {
      temp = head;

      head = head.next;  // 先赋值已保存的对象head
      temp.next = temp.next.next;
      head.next = temp;

      if (result == null) {
        result = head;
      }

      head = head.next.next;
    }

    return result;
  }
}
