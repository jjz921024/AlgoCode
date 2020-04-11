package algo.tree;

import utils.TreeNode;

/**
 * 判断两个树是否相同
 * leetcode 100
 */
public class SameTree {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    // 先判空
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;

    // 判断主要逻辑，值是否相等， 再判断左右子树
    if (p.val != q.val) return false;
    else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

  }
}
