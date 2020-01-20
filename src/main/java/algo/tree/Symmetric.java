package algo.tree;

import utils.TreeNode;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left != root.right) return false;

        if (root.left != null) {
            return isSame(root.left, root.right);
        }
        return true;
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        return left.val == right.val
                && isSame(left.left, right.right)
                && isSame(left.right, right.left);
    }
}
