package algo.tree;

import utils.TreeNode;

public class SearchBST {

  /**
   * 搜索二叉搜索树
   * leetcode 700
   * 类似于求树的最大深度 easy
   */
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;

    if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }


  /**
   * leetcode 965
   * 判断二叉树的节点是不是同一个值
   */
  int val;

  public boolean isUnivalTree(TreeNode root) {
    if (root == null) return true;
    val = root.val;
    return helper(root);
  }

  private boolean helper(TreeNode node) {
    if (node.val != val) {
      return false;
    }

    boolean res = true;
    if (node.left != null) {
      res = helper(node.left);
    }
    if (node.right != null) {
      res = res && helper(node.right);
    }
    return res;
  }
}
