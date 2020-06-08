package algo.list;

import utils.ListNode;

// todo leetcode 328
public class OddEvenList {

  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    else if (head.next == null) return head;

    ListNode oddHead = head;
    ListNode oddTail = head;
    ListNode evenHead = head.next;

    // 从第三个节点开始遍历
    ListNode cur = evenHead.next;

    int count = 1;
    while (cur != null) {
      if (count % 2 == 0) {
        evenHead.next = cur;
        evenHead = evenHead.next;
      } else {
        oddHead.next = cur;
        oddHead = oddHead.next;
        oddTail = cur;
      }
      count += 1;
      cur = cur.next;
    }

    oddTail.next = head.next;
    return head;
  }


}
