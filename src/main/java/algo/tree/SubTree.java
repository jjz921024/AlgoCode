package algo.tree;

import utils.TreeNode;

public class SubTree {

  /**
   * leetcode 572
   * 判断一颗树是否是另一棵树的子树，
   * s的一个子树包括s的一个节点和这个节点的所有子孙
   */
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) return true;   // t 为 null 一定都是 true
    if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
    return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
  }

  // 判断两棵树是否相同
  public boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;
    if (s.val != t.val) return false;
    return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
  }

}
