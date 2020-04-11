package algo.list;

import utils.ListNode;

/**
 * 二进制链表转整数， 节点不超过30，int 32位
 * leetcode 1290
 */
public class ConvertBinaryNumber {
  public int getDecimalValue(ListNode head) {
    if (head == null) return 0;

    int i = 0;
    while (head != null) {
      i = i << 1;  // 乘以2
      if (head.val == 1) {
        i += 1;
      }
      head = head.next;
    }
    return i;
  }

}
