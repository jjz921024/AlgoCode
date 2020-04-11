package algo.tree;

import utils.TreeNode;

/**
 * 判断二叉树是否镜像对称
 * leetcode 101 todo
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left != root.right) return false;


        return true;
    }


}
