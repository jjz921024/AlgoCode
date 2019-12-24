package datastructure.tree;

import java.util.Random;

/**
 * 二叉搜索树 / 二叉排序数 的相关功能
 */
public class BinarySearchTree {

    // 创建二叉排序树，返回根结点
    public static Node creat(int size) {
        if (size <= 0) {
            return null;
        }
        Random random = new Random();
        Node root = new Node(random.nextInt(1000));
        size--;

        while (size-- > 0) {
            insert(root, new Node(random.nextInt(1000)));
        }
        return root;
    }

    private static void insert(Node parent, Node node) {
        if (node.getValue() < parent.getValue()) {
            Node left = parent.getLeft();
            if (left == null) {
                parent.setLeft(node);
            } else {
                insert(left, node);
            }

        } else {
            Node right = parent.getRight();
            if (right == null) {
                parent.setRight(node);
            } else {
                insert(right, node);
            }
        }
    }

    // 以parent为根结点插入大小为value的结点
    public static void insert(Node parent, int value) {
        if (parent == null) {
            return;
        }
        insert(parent, new Node(value));
    }

    public static boolean search(Node node, int key) {
        // node为null是退出条件
        if (node == null) {
            return false;
        } else if (node.getValue() == key) {
            return true;
        } else if (key < node.getValue()) {
            // 返回递归调用的结果
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }

    public static int getDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int left = getDepth(node.getLeft());
            int right = getDepth(node.getRight());
            return 1 + Math.max(left, right);
        }
    }

    /*private static boolean flag = true;
    //中序遍历时记录前驱结点(前一个)last
    private static int last = Integer.MIN_VALUE;

    // 判断一个树/子树是否是二叉排序树
    public static boolean isBSTree(Node node) {
        if (node.getLeft() != null && flag)
            isBSTree(node.getLeft());   //递归到叶子结点

        if (node.getValue() < last)      //左孩子小于双亲  或  双亲小于右孩子
            flag = false;

        last = node.getValue();  //记录前驱
        if (node.getRight() != null && flag)
            isBSTree(node.getRight());
        return flag;
    }*/
}
