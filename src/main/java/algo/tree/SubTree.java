package algo.tree;

import utils.TreeNode;

/**
 * 判断一颗树是否是另一棵树的子树，
 * s的一个子树包括s的一个节点和这个节点的所有子孙
 */
public class SubTree {

  // todo
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if ((s == null && t != null) || (s != null && t == null)) {
      return false;
    }

    if (s != null && s.val != t.val) {
      return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
    }
    return false;
  }
}
