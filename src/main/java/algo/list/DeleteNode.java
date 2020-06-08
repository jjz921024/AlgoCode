package algo.list;

import utils.ListNode;

/**
 * Created by Jun on 2017/8/25.
 */
public class DeleteNode {

  /**
   * 删除倒数第K个节点
   * 倒数第k个节点即使正数第 N-K+1 个节点
   * 关键是找到要删除节点的前一个节点，即第N-K个节点
   * leetcode 19
   */
  public ListNode deleteKthNodeFromTail(ListNode head, int k) {
    if (head == null || k <= 0) return head;

    // 保留头节点留作返回
    ListNode result = head;
    ListNode cur = head;
    while (cur != null) {
      k--;
      cur = cur.next;
    }

    // k等于0，即倒数第N个节点，即是头节点
    if (k == 0) {
      head = head.next;
      // 要删除为头节点的情况
      result = head;

    } else if (k < 0) {
      // 要删除的不是头节点，是中间节点
      // 当加到0时，即使要删除节点的前一个节点 N-k
      while (++k != 0) {
        head = head.next;
      }
      head.next = head.next.next;
    }

    return result;
  }


  /**
   * 删除链表中间的节点
   */
  public ListNode deleteMidNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // 2个节点的情况
    if (head.next.next == null) {
      return head.next;
    }

    ListNode cur = head.next.next;
    ListNode pre = head;
    while (cur.next != null && cur.next.next != null) {
      cur = cur.next.next;
      pre = pre.next;
    }
    pre.next = pre.next.next;
    return head;
  }

  // 未测试
  public ListNode deleteByRatio(ListNode head, int a, int b) {
    if (a > 0 && b > 0 && a < b) {
      int n = 0;
      ListNode cur = head;
      while (cur != null) {
        n++;
        cur = cur.next;
      }
      int r = (int) Math.ceil((double) (a * n / b));


      if (r == 1) {
        head = head.next;
      }
      if (r > 1) {
        cur = head;
        while (--r != 1) {  // TODO: 2017/8/28  != 1
          cur = cur.next;
        }
        cur.next = cur.next.next;
      }
      return head;


    } else {
      return head;
    }
  }


}
