package algo.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 锯齿形层次遍历
 * leetcode 103
 */
public class ZigzagLevelIter {

  List<List<Integer>> levels = new ArrayList<>();

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return levels;
    helper(root, 0);
    return levels;
  }

  private void helper(TreeNode node, int level) {
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    List<Integer> curList = levels.get(level);
    if (level % 2 == 0) {
      curList.add(node.val);
    } else {
      // 从右往左
      curList.add(0, node.val);
    }

    if (node.left != null) {
      helper(node.left, level + 1);
    }
    if (node.right != null) {
      helper(node.right, level + 1);
    }
  }
}
