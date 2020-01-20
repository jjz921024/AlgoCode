package algo.tree;

import utils.TreeNode;

/**
 * leetcode 110
 * 判断树是否是平衡的二叉树
 */
public class Balanced {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        if (Math.abs(right - left) > 1) {
            result = false;
        }
        return 1 + Math.max(right, left);
    }
}
