package algo.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印出二叉树从根到叶子的所有路径
 * leetcode 257
 */
public class TreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    // 最好用linkedList
    // 有个类似全局变量的时候，都要多写一个方法来递归
    ArrayList<String> list = new ArrayList<>();
    if (root == null) return list;

    appendPath(root, "", list);

    return list;
  }

  private void appendPath(TreeNode node, String parent, List<String> list) {

    // 先拼接自己的value
    String current = parent + node.val;
    // 终止条件
    if (node.left == null && node.right == null) {
      list.add(current);
      return;
    }

    if (node.left != null) {
      appendPath(node.left, current + "->", list);
    }

    if (node.right != null) {
      appendPath(node.right, current + "->", list);
    }

  }
}
