package algo.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树广度优先遍历的相关问题
 * BFS / 层次遍历
 */
public class TreeBfsSolution {

  /**
   * 求二叉树的层平均值
   * 就是层次遍历
   * leetcode 637
   */
  ArrayList<List<Integer>> levels = new ArrayList<>();

  public List<Double> averageOfLevels(TreeNode root) {
    ArrayList<Double> result = new ArrayList<>();
    if (root == null) return result;

    levelOrder(root, 0);

    for (List<Integer> level : levels) {
      double sum = 0;
      for (Integer i : level) {
        sum += i;
      }
      result.add(sum / level.size());
    }
    return result;
  }

  // todo 重要
  private void levelOrder(TreeNode node, int level) {
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    levels.get(level).add(node.val);

    if (node.left != null) levelOrder(node.left, level + 1);
    if (node.right != null) levelOrder(node.right, level + 1);
  }


  /**
   * 自底向上的层次遍历
   * leetcode 107
   */
  LinkedList<List<Integer>> res = new LinkedList<>();

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) return new ArrayList<>();
    helper(root, 0);
    return res;
  }

  private void helper(TreeNode node, int level) {
    if (res.size() == level) {
      // addFirst 头插
      res.addFirst(new ArrayList<>());
    }

    // 得到第一层
    res.get(res.size() - level - 1).add(node.val);

    if (node.left != null) helper(node.left, level + 1);
    if (node.right != null) helper(node.right, level + 1);
  }


  /**
   * 锯齿形层次遍历
   * leetcode 103
   */
  List<List<Integer>> zzLevels = new ArrayList<>();

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return zzLevels;
    zigzagHelper(root, 0);
    return zzLevels;
  }

  private void zigzagHelper(TreeNode node, int level) {
    if (zzLevels.size() == level) {
      zzLevels.add(new ArrayList<>());
    }

    List<Integer> curList = zzLevels.get(level);
    if (level % 2 == 0) {
      curList.add(node.val);
    } else {
      // 从右往左
      curList.add(0, node.val);
    }

    if (node.left != null) {
      zigzagHelper(node.left, level + 1);
    }
    if (node.right != null) {
      zigzagHelper(node.right, level + 1);
    }
  }

}
