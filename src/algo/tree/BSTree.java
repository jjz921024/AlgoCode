package algo.tree;

import utils.node.BTreeNode;

/**
 * Created by Jun on 2017/9/18.
 * 二叉搜索树
 */
public class BSTree {
    static boolean flag = true;
    static int last = Integer.MIN_VALUE; //中序遍历时记录前驱结点(前一个)last

    public static boolean isBSTree(BTreeNode root) {
        if (root.left != null && flag)
            isBSTree(root.left);   //递归到叶子结点

        if (root.val < last)      //左孩子小于双亲  或  双亲小于右孩子
            flag = false;

        last = root.val;  //记录前驱
        if (root.right != null && flag)
            isBSTree(root.right);

        return flag;
    }
}
