package algo.list;

import utils.ListNode;
import utils.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 * leetcode 234
 */
public class Palindrome {

  /**
   * 将链表转成数组
   * 该方法不推荐  空间复杂度为0(n)
   */
  public boolean isPalindrome1(Node head) {
    ArrayList<Integer> arr = new ArrayList<>();
    while (head != null) {
      arr.add(head.val);
      head = head.next;
    }

    int i = arr.size();
    int k = i;
    for (int j = 0; j < i / 2; j++) {
      if (arr.get(j).intValue() != arr.get(--k).intValue())
        return false;
    }
    return true;
  }

  /**
   * 利用栈，将链表压入栈中，再依次弹出对比
   * 空间复杂度0(n)
   */
  public boolean isPalindrome2(Node head) {
    Stack<Integer> stack = new Stack<Integer>();
    Node cur = head;
    while (cur != null) {
      stack.push(cur.val);
      cur = cur.next;
    }

    while (head != null && !stack.isEmpty()) {
      if (stack.pop() != head.val)
        return false;
      head = head.next;
    }
    return true;
  }

  /**
   * 只将一半的链表入栈，节省一半空间
   */
  public boolean isPalindrome3(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode right = head.next;
    ListNode cur = head;
    while (cur.next != null && cur.next.next != null) {
      cur = cur.next.next;
      right = right.next;
    }
    Stack<Integer> stack = new Stack<>();
    // 链表右边入栈
    while (right != null) {
      stack.push(right.val);
      right = right.next;
    }
    while (!stack.isEmpty()) {
      if (stack.pop() != head.val)
        return false;
      head = head.next;
    }
    return true;
  }

  /**
   * 空间复杂度 0(1) 解法
   */
  public boolean isPalindrome4(ListNode head) {
    // todo
    return false;
  }

}