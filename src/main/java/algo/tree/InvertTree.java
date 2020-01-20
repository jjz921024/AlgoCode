package algo.tree;

import utils.TreeNode;

/**
 * leetcode 226
 * 翻转二叉树
 */
public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 子节点翻转
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        // 返回头
        return root;
    }

}
