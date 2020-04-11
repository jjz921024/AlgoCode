package algo.tree;

import java.util.List;

/**
 * n叉树的最大深度
 * leetcode 559
 */
public class MaxDepthNTree {

  public int maxDepth(Node root) {
    if (root == null) return 0;

    int depth = 0;
    List<Node> children = root.children;
    for (Node child : children) {
      depth = Math.max(depth, maxDepth(child));
    }

    return depth + 1;
  }


}

class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}