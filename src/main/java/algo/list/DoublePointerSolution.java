package algo.list;

import utils.ListNode;

/**
 * 双指针技巧 - 快慢指针
 * 常用于链表
 */
public class DoublePointerSolution {

  /**
   * 返回单链表的中间节点，双数返回后一个
   * leetcode 876
   */
  public ListNode middleNode(ListNode head) {
    ListNode l1 = head;
    ListNode l2 = head;

    while (l2 != null && l2.next != null) {
      l1 = l1.next;
      l2 = l2.next.next;
    }
    return l1;
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


  /**
   * leetcode 19 删除倒数第K个节点
   * 方法一：分两次遍历
   * 倒数第k个节点即使正数第 N-K+1 个节点
   * 关键是找到要删除节点的前一个节点，即第 N-K个节点
   */
  public ListNode removeNthFromEnd(ListNode head, int k) {
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
      // 当加到0时，即是要删除节点的前一个节点 N-k
      while (++k != 0) {
        head = head.next;
      }
      head.next = head.next.next;
    }

    return result;
  }

  // 方法二：快慢指针，一次遍历
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (head == null || n <= 0) return head;

    // 虚拟头节点，多走n+1步
    ListNode dummy = new ListNode(0);
    ListNode fast = dummy, slow = dummy;
    dummy.next = head;
    while (n-- >= 0) {
      fast = fast.next;
    }

    // 循环结束时，slow指向的下一个节点为要删除的节点
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }


  /**
   * 删除链表 a/b 处的节点
   * length * (a / b) 向上取整
   */
  public static ListNode deleteByRatio(ListNode head, int a, int b) {
    if (a < 0 || b < 0 || a > b) return head;

    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }
    int delIndex = (int) Math.ceil((double) (a * n / b));

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    if (delIndex == 1) {
      head = head.next;
    } else if (delIndex > 1) {
      while (delIndex-- >= 0) {
        dummy = dummy.next;
      }
      dummy.next = dummy.next.next;
    }
    return head;
  }

}
