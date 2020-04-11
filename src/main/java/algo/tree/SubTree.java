package algo.tree;

import utils.TreeNode;

/**
 * 判断一颗树是否是另一棵树的子树，
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙
 * <p>
 * todo 未完成
 */
public class SubTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {

    if ((s == null && t != null) || (s != null && t == null)) {
      return false;
    }
    if (s.val != t.val
      || s.right != t.right
      || s.left != t.left) {
      return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
    }
    return false;
  }
}
