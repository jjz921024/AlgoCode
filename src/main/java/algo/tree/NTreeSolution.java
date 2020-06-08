package algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树
 */
public class NTreeSolution {

  /**
   * n叉树的后序遍历
   * leetcode 590
   */
  public List<Integer> postOrder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    postOrderHelper(root, list);
    return list;
  }

  private void postOrderHelper(Node node, List<Integer> list) {
    if (node == null)
      return;

    List<Node> children = node.children;
    for (Node child : children) {
      postOrderHelper(child, list);
    }
    list.add(node.val);
  }


  /**
   * n叉树的前序遍历
   * leetcode 589
   */
  public List<Integer> preOrder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();

    preOrderHelper(root, list);

    return list;
  }

  private void preOrderHelper(Node node, List<Integer> list) {
    if (node == null)
      return;

    list.add(node.val);
    List<Node> children = node.children;
    for (Node child : children) {
      preOrderHelper(child, list);
    }
  }

  /**
   * n叉树的最大深度
   * leetcode 559
   */
  public int maxDepth(Node root) {
    if (root == null) return 0;

    int depth = 0;
    List<Node> children = root.children;
    for (Node child : children) {
      depth = Math.max(depth, maxDepth(child));
    }

    return depth + 1;
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
}
