package algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * n叉树的后序遍历
 * leetcode 590
 */
public class NTreePostOrder {

  public List<Integer> postorder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();

    order(root, list);

    return list;
  }

  private void order(Node node, List<Integer> list) {
    if (node == null)
      return;

    List<Node> children = node.children;
    for (Node child : children) {
      order(child, list);
    }
    list.add(node.val);
  }
}
