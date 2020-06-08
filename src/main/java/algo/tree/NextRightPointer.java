package algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 116 / 117
 * 一种解法A两道题
 */
public class NextRightPointer {

  List<List<Node>> levels = new ArrayList<>();

  public Node connect(Node root) {
    if (root == null) return null;
    helper(root, 0);
    return root;
  }

  // 利用层次遍历
  private void helper(Node node, int level) {
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    List<Node> curLevel = levels.get(level);
    if (curLevel.size() != 0) {
      Node prev = curLevel.get(curLevel.size() - 1);
      prev.next = node;
    }
    curLevel.add(node);

    if (node.left != null) {
      helper(node.left, level + 1);
    }
    if (node.right != null) {
      helper(node.right, level + 1);
    }
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}


