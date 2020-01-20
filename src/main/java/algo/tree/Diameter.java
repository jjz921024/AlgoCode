package algo.tree;

import utils.TreeNode;

/**
 * leetcode 543
 *
 * 搜索每个节点的 左子树深度 + 右子树深度，求最大值
 */
public class Diameter {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(max, l + r);
        // 返回左右子树中最大的高度
        return Math.max(l, r) + 1;
    }
}
