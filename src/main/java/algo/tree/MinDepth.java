package algo.tree;

import utils.TreeNode;

/**
 * 求树的最小深度, 根到最近叶子节点的深度
 * leetcode 111
 */
public class MinDepth {

  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null && root.right == null) return 1;

    // 是取最小值
    int min = Integer.MAX_VALUE;
    if (root.left != null) {
      min = Math.min(min, minDepth(root.left));
    }
    if (root.right != null) {
      min = Math.min(min, minDepth(root.right));
    }

    return min + 1;
  }
}
