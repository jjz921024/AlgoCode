package algo.tree;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的坡度
 * leetcode 653
 */
public class TreeTilt {

  public int findTilt(TreeNode root) {
    if (root == null) return 0;

    int sum = 0;
    TreeNode node;

    // 遍历每个节点
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      node = queue.poll();
      if (node.left != null)
        queue.offer(node.left);
      if (node.right != null)
        queue.offer(node.right);
      // 累加得到二叉树的坡度
      sum += calTiltByNode(node);
    }
    return sum;
  }

  // 计算每个节点的坡度
  private int calTiltByNode(TreeNode node) {
    return Math.abs(preOrder(node.left) - preOrder(node.right));
  }

  // 前序遍历，算一个节点的和
  private int preOrder(TreeNode node) {
    if (node == null) return 0;
    return node.val + preOrder(node.left) + preOrder(node.right);
  }

}
