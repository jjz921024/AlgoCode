package structure.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 二叉搜索树 / 二叉排序数 的相关功能
 * todo: 删除操作，判断是否是二叉排序树
 */
public class BinarySearchTree {

    // 创建二叉排序树，返回根结点
    public static TreeNode creat(int size) {
        if (size <= 0) {
            return null;
        }
        Random random = new Random();
        TreeNode root = new TreeNode(random.nextInt(1000));
        size--;

        while (size-- > 0) {
            insert(root, new TreeNode(random.nextInt(1000)));
        }
        return root;
    }

    private static void insert(TreeNode parent, TreeNode treeNode) {
        if (treeNode.getValue() < parent.getValue()) {
            TreeNode left = parent.getLeft();
            if (left == null) {
                parent.setLeft(treeNode);
            } else {
                insert(left, treeNode);
            }

        } else {
            TreeNode right = parent.getRight();
            if (right == null) {
                parent.setRight(treeNode);
            } else {
                insert(right, treeNode);
            }
        }
    }

    // 以parent为根结点插入大小为value的结点
    public static void insert(TreeNode parent, int value) {
        if (parent == null) {
            return;
        }
        insert(parent, new TreeNode(value));
    }

    public static boolean search(TreeNode treeNode, int key) {
        // node为null是退出条件
        if (treeNode == null) {
            return false;
        } else if (treeNode.getValue() == key) {
            return true;
        } else if (key < treeNode.getValue()) {
            // 返回递归调用的结果
            return search(treeNode.getLeft(), key);
        } else {
            return search(treeNode.getRight(), key);
        }
    }

    public static int getDepth(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        else {
            int left = getDepth(treeNode.getLeft());
            int right = getDepth(treeNode.getRight());
            return 1 + Math.max(left, right);
        }
    }

    // 判断一个树是否是二叉排序树, 中序遍历
    // [10, 5, 15, null, null, 6, 20]这个用例，一个节点的右子树上的节点都要大于它
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        midIter(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void midIter(TreeNode node, List<Integer> list) {
        if (node == null) return;
        midIter(node.left, list);
        list.add(node.val);
        midIter(node.right, list);
    }
}
