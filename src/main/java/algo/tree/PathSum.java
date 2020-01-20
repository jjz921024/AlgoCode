package algo.tree;


import utils.TreeNode;

public class PathSum {

    /**
     * leetcode 112
     * 判断是否有 根节点到叶子节点的累加和等于sum
     * todo： review
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // 根节点为0且sum为0的情况
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    /**
     * leetcode 437
     *
     */
    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return result;
    }
}
