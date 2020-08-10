package algo.list;

import utils.ListNode;

/**
 * leetcode 328
 * 将奇偶链表分别排在一起
 */
public class OddEvenList {

  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    else if (head.next == null) return head;

    // 第一个节点视为奇数节点
    ListNode odd = head;           // 奇链表的头指针head，尾指针odd
    ListNode evenHead = head.next; // 偶链表的头指针
    ListNode even = evenHead;      // 偶链表的尾指针

    while (even != null && even.next != null) {  // 注意终止条件
      odd.next = even.next;
      odd = odd.next;

      even.next = odd.next;
      even = even.next;
    }

    // 奇节点末尾拼接偶节点头
    odd.next = evenHead;
    return head;
  }

}
