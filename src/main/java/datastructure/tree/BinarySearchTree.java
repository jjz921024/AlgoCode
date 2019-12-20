package datastructure.tree;

/**
 * 二叉搜索树 / 二叉排序数 的相关功能
 */
public class BinarySearchTree {

    private static boolean flag = true;
    private static int last = Integer.MIN_VALUE; //中序遍历时记录前驱结点(前一个)last

    public static boolean isBSTree(Node root) {
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
