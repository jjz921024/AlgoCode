package algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * n叉树的前序遍历
 * leetcode 589
 */
public class NTreePreOrder {
  public List<Integer> preorder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();

    order(root, list);

    return list;
  }

  private void order(Node node, List<Integer> list) {
    if (node == null)
      return;

    list.add(node.val);
    List<Node> children = node.children;
    for (Node child : children) {
      order(child, list);
    }
  }

}
