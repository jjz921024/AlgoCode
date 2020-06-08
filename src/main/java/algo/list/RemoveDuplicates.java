package algo.list;

import utils.ListNode;
import utils.Node;

import java.util.HashSet;

/**
 * Created by Jun on 2017/8/28.
 * 删除链表中值重复出现的节点  （链表不一定升序）
 */
public class RemoveDuplicates {

  /**
   * 利用哈希表
   * 时间复杂度为0(n),空间复杂度为0(n)
   */
  public void deleteDuplicates(Node head) {
    HashSet<Integer> hashSet = new HashSet<>();
    hashSet.add(head.val);
    Node pre = head;
    head = head.next;

    while (head != null) {
      if (hashSet.contains(head.val))
        pre.next = head.next;
      else {
        hashSet.add(head.val);
        pre = pre.next;
      }
      head = head.next;
    }
  }

  /**
   * 类似选择排序
   * 空间复杂度0(1)，时间复杂度0(n*n)
   */
  public void deleteDuplicates2(Node head) {
    Node cur = head;  // 这一次循环的基准
    Node pre = null;
    Node next = null;
    while (cur != null) {
      pre = cur;
      next = cur.next;
      while (next != null) {
        if (cur.val != next.val)
          pre.next = next.next;
        else
          pre = next;
        next = next.next;
      }
      cur = cur.next;   // 取下一个要比较的节点
    }
  }




  /**
   * 删除 升序链表 中重复的元素
   * leetcode 83
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;

    while (current != null && current.next != null) {
      if (current.val == current.next.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

  /**
   * 删除 升序链表 中重复的元素，只要是重复的元素，把该元素都删除
   * leetcode 82
   * todo
   */
  public ListNode deleteDuplicates2(ListNode head) {
    if (head == null) return null;

    ListNode current = head.next;
    ListNode prev = head;

    while (current != null && current.next != null) {

    }



    return head;
  }

}
