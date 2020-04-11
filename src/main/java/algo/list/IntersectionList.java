package algo.list;

import utils.ListNode;

/**
 * 找出相交链表的交点  Y型链表
 * leetcode 160
 */
public class IntersectionList {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode temp = headA;
    int lenA = 0;
    while (headA != null) {
      lenA += 1;
      headA = headA.next;
    }
    headA = temp;

    temp = headB;
    int lenB = 0;
    while (headB != null) {
      lenB += 1;
      headB = headB.next;
    }
    headB = temp;

    ListNode lengthNode;
    ListNode shortNode;

    if (lenA > lenB) {
      lengthNode = headA;
      shortNode = headB;
    } else {
      lengthNode = headB;
      shortNode = headA;
    }

    int minus = Math.abs(lenA - lenB);
    while ((minus -= 1) >= 0) { // 注意等号，想相差1个节点时的情况来判断是否加等号
      lengthNode = lengthNode.next;
    }

    while (lengthNode != null && shortNode != null) {
      if (lengthNode == shortNode) {
        return lengthNode;
      }
      lengthNode = lengthNode.next;
      shortNode = shortNode.next;
    }

    return null;
  }
}
