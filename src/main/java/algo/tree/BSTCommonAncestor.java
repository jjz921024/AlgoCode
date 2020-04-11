package algo.tree;

import utils.TreeNode;

/**
 * 返回二叉搜索树的中2个节点的公共祖先
 * leetcode 235
 */
public class BSTCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    // 两个节点在根节点两边的情况
    if (p.val < root.val && q.val > root.val) {
      return root;
    }
    if (q.val < root.val && p.val > root.val) {
      return root;
    }

    // 有一个节点与根节点相等的情况
    if (p.val == root.val || q.val == root.val) {
      return root;
    }

    // 都在一边的情况  题目保证给点节点肯定存在于二叉树中
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }

  }
}
