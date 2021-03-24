package algo.list;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 升序链表合并为一个新的升序链表
 * leetcode 21
 */
public class MergeList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    else if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  /**
   * leetcode 23
   * 合并K个升序链表
   * 方法一：每次取最小的ListNode进行合并
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) return null;

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while(hasElement(lists)) {
      cur.next = removeLargest(lists);
      cur = cur.next;
    }
    System.gc();
    return dummy.next;
  }

  private ListNode removeLargest(ListNode[] lists) {
    ListNode min = null;
    int idx = 0;
    for(int i=0; i<lists.length; i++) {
      if(lists[i] == null) continue;
      ListNode cur = lists[i];

      if(min == null) {
        min = cur;
        idx = i;
      } else if(min.val > cur.val) {
        idx = i;
        min = cur;
      }
    }
    // 不能min = min.next
    // 要用索引在数组上next
    lists[idx] = lists[idx].next;
    return min;
  }

  private boolean hasElement(ListNode[] lists) {
    for (ListNode list : lists) {
      if (list != null) return true;
    }
    return false;
  }

  // 方法二：维护小顶堆
  public ListNode mergeKLists2(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (ListNode list : lists) {
      while (list != null) {
        queue.add(list);
        list = list.next;
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      ListNode poll = queue.poll();
      // 有可能成环
      poll.next = null;
      cur.next = poll;
      cur = cur.next;
    }

    return dummy.next;
  }

}
