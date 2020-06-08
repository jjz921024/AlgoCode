package algo.tree;

import utils.TreeNode;

/**
 * 计算所有左叶子之和
 * todo
 */
public class LeftLeavesSum {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;

    TreeNode parent = root;
    int sum = 0;

    if (root.left != null) {
      sum += helper(root.left, root);
    }
    if (root.right != null) {
      sum += helper(root.right, root);
    }

    return 0;
  }

  private int helper(TreeNode node, TreeNode parent) {
    if (node.left == null && node.right == null) {
      return node.val;
    }

    return 1;
  }
}
