package algo.tree;

import utils.TreeNode;

public class PruneSolution {

  /**
   * 剪枝 / 删除指定节点相关
   * 思路：后序遍历，在父节点上判断左右子节点是否需要删除
   * leetcode 814
   * leetcode 1325
   */
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if(root == null) return null;

    removeLeafNodes(root.left, target);
    removeLeafNodes(root.right, target);

    TreeNode left = root.left;
    if(left != null && left.left == null && left.right == null && left.val == target) {
      root.left = null;
    }

    TreeNode right = root.right;
    if(right != null && right.left == null && right.right == null && right.val == target) {
      root.right = null;
    }

    if(root.left == null && root.right == null && root.val == target) return null;

    return root;
  }
}
