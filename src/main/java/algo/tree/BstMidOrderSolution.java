package algo.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 利用二叉搜索树中序遍历的性质
 */
public class BstMidOrderSolution {

  /**
   * 二叉搜索树转化成累加树
   * leetcode 538
   */
  int prev;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;
    // 倒着中序遍历
    convertBST(root.right);

    // 将大于节点的值累加到当前节点上
    root.val += prev;
    prev = root.val;

    convertBST(root.left);
    return root;
  }


  /**
   * 二叉搜索树的最小绝对差
   * leetcode 530
   */
  int min = Integer.MAX_VALUE;
  int prevDiff = Integer.MAX_VALUE;  // prev也要设为最大值，边界  [1, null, 5, 3]

  public int getMinimumDifference(TreeNode root) {
    midOrderDiff(root);
    return min;
  }

  private void midOrderDiff(TreeNode node) {
    if (node == null) return;

    midOrderDiff(node.left);

    int temp = Math.abs(node.val - prevDiff);
    if (temp < min) {
      min = temp;
    }
    prevDiff = node.val;

    midOrderDiff(node.right);
  }


  /**
   * 找二叉搜索树中的众数
   * leetcode 501
   */
  ArrayList<Integer> modes = new ArrayList<>();
  int count = 0;
  int max = 0;
  int current;

  public int[] findMode(TreeNode root) {
    if (root == null) return new int[0];

    current = root.val;
    midOrderModes(root);

    int[] result = new int[modes.size()];
    for (int i = 0; i < modes.size(); i++) {
      result[i] = modes.get(i);
    }
    return result;
  }

  private void midOrderModes(TreeNode node) {
    if (node == null) return;

    midOrderModes(node.left);

    // 有序链表找众数
    if (current == node.val) {
      count += 1;
    } else {
      count = 1; // 这里count设回1
      current = node.val;
    }

    if (count == max) {
      modes.add(node.val);
    } else if (count > max) {
      modes.clear();
      max = count;
      modes.add(current);
    }

    midOrderModes(node.right);
  }


  /**
   * 二叉搜索树中的两数之和
   * leetcode 653
   *
   * 方法1： 直接遍历存hashset
   * 方法2： 中序遍历存list， 头尾双指针
   */
  Set<Integer> set = new HashSet<>();

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) return false;

    midOrderTs(root);

    for (Integer i : set) {
      if (set.contains(k - i) && i != k - i) {
        return true;
      }
    }
    return false;
  }

  private void midOrderTs(TreeNode node) {
    if (node == null) return;

    midOrderTs(node.left);
    set.add(node.val);
    midOrderTs(node.right);
  }
}
