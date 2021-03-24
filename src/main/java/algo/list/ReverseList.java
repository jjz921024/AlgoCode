package algo.list;

import utils.ListNode;
import utils.Node;

public class ReverseList {

  /**
   * leetcode 206 反转链表
   * 迭代方式
   */
  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;  // 翻转，当前头节点的next改成指向前一个节点prev
      prev = head;  // 往下走
      head = next;
    }
    return prev;
  }

  // 递归翻转链表
  public Node reverse2(Node node) {
    if (node.next == null) {
      return node;
    }

    // 先翻转node结点之后的链表
    Node newHead = reverse2(node.next);

    // 再把原 node 节点后继结点的后继结点指向 node，node 的后继节点设置为空(防止形成环)
    node.next.next = node;
    node.next = null;

    // 返回翻转后的头结点
    return newHead;
  }


  /**
   * leetcode 92
   * 翻转位置从from到to的结点（从1开始计）
   */
  public ListNode reversePartList(ListNode head, int from, int to) {
    if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // 遍历到左侧节点的前一个位置
    ListNode prev = dummy;
    for (int i = 0; i < from - 1; i++) {
      prev = prev.next;
    }

    // 遍历到右侧节点
    ListNode rightNode = prev;
    for (int i = from; i <= to; i++) {
      rightNode = rightNode.next;
    }

    // 截断链表
    ListNode leftNode = prev.next;
    ListNode temp = rightNode.next;

    prev.next = null;
    rightNode.next = null;

    // 反转
    reverse(leftNode);

    // 拼接回原链表
    prev.next = rightNode;
    leftNode.next = temp;

    // 不能直接返回head
    return dummy.next;
  }

  // 方法二
  public ListNode reversePartList2(ListNode head, int left, int right) {
    if(head == null || head.next == null) return head;

    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // 走到待反转节点的前一位
    ListNode cur = dummy;
    while(left-- > 1) {
      cur = cur.next;
      right--;
    }
    ListNode l = cur;

    // 走到最后一个待反转节点
    while(right-- > 0) {
      cur = cur.next;
    }
    ListNode r = cur;

    // 截断待反转链表
    ListNode temp = l.next;
    l.next = null;

    ListNode tail = r.next;
    r.next = null;

    // 反转后的头节点是h
    ListNode h = reverse(temp);

    // 拼接
    l.next = h;
    temp.next = tail;

    return dummy.next;
  }

  /**
   * leetcode 24 两两交换链表中相邻节点  (2个一组反转链表)
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode n1 = head;
    ListNode n2 = head.next;

    // 翻转剩余部分，返回的节点拼接在n1后
    n1.next = swapPairs(n2.next);  // !!!

    n2.next = n1;
    return n2;
  }

  /**
   * k个一组翻转链表
   */
  public ListNode reverseGroup(ListNode head, int k) {
    if (head == null) return null;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (head != null) {
      ListNode tail = prev;
      for (int i = 0; i < k; i++) {
        tail = tail.next;
        if (tail == null) {
          return dummy.next;
        }
      }

      ListNode next = tail.next;
      ListNode[] reverse = reverseBetween(head, tail);
      head = reverse[0];
      tail = reverse[1];

      prev.next = head;
      tail.next = next;
      prev = tail;
      head = tail.next;
    }

    return dummy.next;
  }

  public ListNode[] reverseBetween(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode p = head;
    while (prev != tail) {
      ListNode next = p.next;
      p.next = prev;
      prev = p;
      p = next;
    }
    return new ListNode[]{tail, head};
  }
}
