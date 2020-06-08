package algo.list;

import utils.ListNode;
import utils.Node;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/28.
 * 相加链表
 * leetcode 445
 */
public class AddLists {

  /**
   * 利用栈结构
   */
  public static ListNode addList1(ListNode l1, ListNode l2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    while (l1 != null) {
      stack1.push(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      stack2.push(l2.val);
      l2 = l2.next;
    }

    ListNode head = null, pre;
    int ca = 0;
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      int n1 = stack1.isEmpty() ? 0 : stack1.pop();
      int n2 = stack2.isEmpty() ? 0 : stack2.pop();
      int n = n1 + n2 + ca;
      ca = n / 10;

      pre = head;  // 头插法
      head = new ListNode(n % 10);
      head.next = pre;
    }
    if (ca == 1) {
      pre = head;
      head = new ListNode(1);
      head.next = pre;
    }
    return head;
  }

  /**
   * 将链表倒序相加
   * 该方法会修改链表
   */
  public static Node addList2(Node head1, Node head2) {
        /*Node node1 = ReverseList.reverse(head1);
        Node node2 = ReverseList.reverse(head2);

        int ca = 0;
        Node head = null;
        Node pre = null;
        while (node1 != null || node2 != null) {
            int n1 = node1==null ? 0 : node1.val;
            int n2 = node2==null ? 0 : node2.val;
            int n = n1 + n2 + ca;
            ca = n / 10;

            pre = head;
            head = new Node(n % 10);
            head.next = pre;

            node1 = node1==null ? null : node1.next;
            node2 = node2==null ? null : node2.next;
        }
        if (ca == 1) {
            pre = head;
            head = new Node(1);
            head.next = pre;
        }
        return head;*/
    return null;
  }


  /**
   * 链表两数相加，数的表示是倒序的，最低位在头节点
   * leetcode 2
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return new ListNode(0);
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode result = null, temp = null;
    int ca = 0;
    while (l1 != null || l2 != null || ca != 0) {
      int a, b;
      if (l1 == null) {
        a = 0;
        l1 = null;
      } else {
        a = l1.val;
        l1 = l1.next;
      }

      if (l2 == null) {
        b = 0;
        l2 = null;
      } else {
        b = l2.val;
        l2 = l2.next;
      }

      ListNode node = new ListNode((a + b + ca) % 10);
      ca = (a + b + ca) / 10;

      if (result == null) {
        result = node;
        temp = node;
      } else {
        temp.next = node;
        temp = temp.next;
      }

    }

    return result;
  }

}
