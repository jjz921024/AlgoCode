package algo.tree;

import utils.TreeNode;

public class LrBST {


  /**
   * 修剪二叉树
   * leetcode 669
   */
  public TreeNode trimBST(TreeNode root, int L, int R) {

    // 只剪右枝
    if (root.val < L) {
      root.left = null;
      trimBST(root.right, L, R);
    }
    if (root.val > R) {
      root.right = null;
      trimBST(root.left, L, R);
    }



    // todo

    return root;
  }



  /**
   * BST的范围和
   * leetcode 938
   * 普通的遍历即可AC，还可通过BST的性质优化，减少不必要的遍历
   */
  int sum = 0;

  public int rangeSumBST(TreeNode root, int L, int R) {
    dfs(root, L, R);
    return sum;
  }

  private void dfs(TreeNode node, int L, int R) {
    if (node != null) {
      if (node.val >= L && node.val <= R) {
        sum += node.val;
      }

      // 左节点还需要继续遍历
      if (node.val > L) {
        dfs(node.left, L, R);
      }
      if (node.val < R) {
        dfs(node.right, L, R);
      }

    }
  }



}
