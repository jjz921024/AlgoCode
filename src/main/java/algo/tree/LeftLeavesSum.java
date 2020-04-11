package algo.tree;

import utils.TreeNode;

/**
 * 计算所有左叶子之和
 * todo
 */
public class LeftLeavesSum {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;

    // 终止条件，判断左叶子

    //sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    /*if (root.left != null && root.left.right == null && root.left.left == null) {
      return root.left.val;
    }*/

    return 0;
  }
}
