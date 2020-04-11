package algo.tree;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    /**
     * leetcode 112
     * 判断是否有 根节点到叶子节点的累加和等于sum
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
     * leetcode 113
     * 找到所有从根节点到叶子节点路径总和等于给定目标和的 路径
     * todo
     */
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();

        return null;
    }




    /**
     * leetcode 437
     * 找出路径和等于给定值的路径的总数，路径不需要从根节点开始，也不需要在叶子节点结束
     * todo
     */
    private int result = 0;

    public int pathSum3(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return result;
    }
}
