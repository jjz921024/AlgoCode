package algo.list;

import utils.ListNode;
import utils.TreeNode;

/**
 * 有序数组转二叉搜索树
 * leetcode 109  类似 leetcode 108
 */
public class LinkedBST {
  public TreeNode sortedListToBST(ListNode head) {
    // 递归退出条件
    if (head == null) return null;
    else if (head.next == null) return new TreeNode(head.val);

    // 快慢指针
    ListNode prev = head;
    ListNode slowNode = prev.next;
    ListNode fastNode = prev.next.next;

    while (fastNode != null && fastNode.next != null) {
      prev = prev.next;
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    // 将链表断开
    prev.next = null;
    TreeNode root = new TreeNode(slowNode.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slowNode.next);

    return root;
  }



}
