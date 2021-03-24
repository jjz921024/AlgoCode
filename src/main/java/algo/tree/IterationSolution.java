package algo.tree;

import utils.TreeNode;
import utils.TreeNodeWithNextPrt;

public class IterationSolution {

  /**
   * leetcode 1008
   * 根据前序遍历构建二叉搜索树
   */
  public TreeNode bstFromPreorder(int[] preorder) {
    if(preorder == null || preorder.length == 0) return null;
    return build(preorder, 0, preorder.length);
  }

  private TreeNode build(int[] preorder, int from, int to) {
    if(from >= to) return null;
    TreeNode root = new TreeNode(preorder[from]);

    // note 前部分索引初始化为全部
    int flag = to;
    for(int i = from + 1; i < to; i++) {
      if(preorder[i] > preorder[from]) {
        flag = i;
        break;
      }
    }

    root.left = build(preorder, from + 1, flag);
    root.right = build(preorder, flag, to);

    return root;
  }

  /**
   * leetcode 116 填充每个节点的右侧节点指针
   * 前序遍历 或 层次遍历后再连接
   */
  TreeNodeWithNextPrt connect(TreeNodeWithNextPrt root) {
    if (root == null) return null;
    connectTwoNode(root.left, root.right);
    return root;
  }

  // 定义：输入两个节点，将它俩连接起来
  void connectTwoNode(TreeNodeWithNextPrt node1, TreeNodeWithNextPrt node2) {
    if (node1 == null || node2 == null) {
      return;
    }

    // 前序遍历位置，将传入的两个节点连接
    node1.next = node2;

    // 连接相同父节点的两个子节点
    connectTwoNode(node1.left, node1.right);
    connectTwoNode(node2.left, node2.right);
    // 连接跨越父节点的两个子节点
    connectTwoNode(node1.right, node2.left);
  }


  /**
   * leetcode 98 验证二叉搜索树
   */
  boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
  boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    // base case
    if (root == null) return true;
    // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
    if (min != null && root.val <= min.val) return false;
    if (max != null && root.val >= max.val) return false;
    // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
    return isValidBST(root.left, min, root)
      && isValidBST(root.right, root, max);
  }
}
