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

  /**
   * leetcode 701 二叉搜索树中的插入操作
   * 假定不会插入已存在元素
   */
  public TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);

    if (root.val < val)
      // 根节点小于val，往右子树插
      root.right = insertIntoBST(root.right, val);
    if (root.val > val)
      root.left = insertIntoBST(root.left, val);
    return root;
  }

  /**
   * leetcode 450 删除二叉搜索树中的节点
   * 情况1：要删除的节点是叶子节点，直接置为空
   * 情况2：要删除的节点有一个非空子节点，让子节点替换
   * 情况3：有两个子节点，找到左子树中最大的节点 或者 右子树中最小的节点来接替自己
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if(root.val == key) {
      // 找到要删除的节点了，区分三种情况

      // 包含了情况1和2
      if(root.left == null) return root.right;
      if(root.right == null) return root.left;

      // 情况3
      TreeNode minNode = getMin(root.right);
      root.val = minNode.val;
      root.right = deleteNode(root.right, minNode.val);

    } else if(root.val > key) {
      // 去左子树找
      root.left = deleteNode(root.left, key);
    } else if(root.val < key) {
      // 去右子树找
      root.right = deleteNode(root.right, key);
    }
    return root;
  }

  private TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
  }


}
