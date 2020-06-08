package algo.tree;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

  /**
   * leetcode 112
   * 判断是否有 根节点到叶子节点的累加和等于sum
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    // 根节点为0且sum为0的情况
    if (root.left == null && root.right == null && root.val == sum) return true;
    return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
  }


  /**
   * leetcode 113
   * 找到所有从根节点到叶子节点路径总和等于给定目标和的 路径
   * todo
   */
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) return result;

    helper(root, sum, new LinkedList<>());

    return result;
  }

  private void helper(TreeNode node, int sum, LinkedList<Integer> list) {
    if (node == null) return;

    if (node.left == null && node.right == null && sum == 0) {
      result.add(list);
    }

    sum -= node.val;
    list.add(node.val);

    helper(node.left, sum, list);
    helper(node.right, sum, list);


    list.removeLast();
  }




  /**
   * leetcode 437
   * 找出路径和等于给定值的路径的总数，路径不需要从根节点开始，也不需要在叶子节点结束
   * todo
   */
  /*private int result = 0;

  public int pathSum3(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    return result;
  }*/

  /**
   * 求根到叶子节点数字之和
   * leetcode 129， 思路类似leetcode 257
   */
  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;

    ArrayList<Integer> pathNum = new ArrayList<>();

    calPathSum(root, 0, pathNum);

    int sum = 0;
    for (Integer i : pathNum) {
      sum += i;
    }
    return sum;
  }

  private void calPathSum(TreeNode node, int sum, List<Integer> list) {
    if (node == null) return;

    sum = sum * 10 + node.val;

    if (node.left == null && node.right == null) {
      list.add(sum);
    }

    calPathSum(node.left, sum, list);
    calPathSum(node.right, sum, list);
  }


  /**
   * 二进制的路径和
   * leetcode 1022  思路同129
   */
  ArrayList<Integer> bitPath = new ArrayList<>();


  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return 0;

    helper(root, 0);

    int sum = 0;
    for (Integer i : bitPath) {
      sum += i;
    }
    return sum;
  }

  private void helper(TreeNode node, int acc) {
    if (node == null) return;

    if (node.left == null && node.right == null) {
      bitPath.add(acc + node.val);
    }

    int cur = (acc + node.val) << 1;
    helper(node.left, cur);
    helper(node.right, cur);

  }

}
