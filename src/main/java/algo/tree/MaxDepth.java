package algo.tree;

import utils.TreeNode;

/**
 * 求二叉树的深度
 * leetcode 104
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
