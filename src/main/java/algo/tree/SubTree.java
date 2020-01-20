package algo.tree;

import utils.TreeNode;

/**
 * todo 未完成
 */
public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;

        if (t != null) {
            if (s.val != t.val) return false;
            if (t.right != null || t.left != null) return false;
            return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
        }
        return true;
    }
}
