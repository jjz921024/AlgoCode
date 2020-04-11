package algo.tree;

import utils.TreeNode;

/**
 * 将有序数组转为二叉搜索树
 * leetcode 108
 */
public class ArrayBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;

    // 注意数组下标
    return genTree(nums, 0, nums.length - 1);
  }

  private TreeNode genTree(int[] nums, int from, int to) {
    // 重要，递归退出条件
    if (from > to) {
      return null;
    }
    // 向下取整
    int mid = (from + to) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = genTree(nums, from, mid - 1);
    node.right = genTree(nums, mid + 1, to);
    return node;
  }
}
