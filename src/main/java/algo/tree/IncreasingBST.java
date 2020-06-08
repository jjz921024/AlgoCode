package algo.tree;

import utils.TreeNode;

//todo 897
public class IncreasingBST {

  public TreeNode increasingBST(TreeNode root) {
    return dfs(root);

  }

  private TreeNode dfs(TreeNode node) {
    if (node == null) return null;



    dfs(node.left);



    dfs(node.right);

    // 递归到最小的节点，返回此节点
    TreeNode treeNode = new TreeNode(node.val);

    // 回到父节点
    treeNode.right = node;

    return treeNode;
  }
}
