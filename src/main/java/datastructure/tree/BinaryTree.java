package datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树实现
 */
public class BinaryTree {

    // 创建二叉树, 链表中结点的顺序是二叉树前序
    // 有将空结点表示出来的数组可以唯一确定一棵二叉树
    public static Node create(LinkedList<Integer> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        Integer data = input.removeFirst();
        Node node = null;
        if (data != null) {
            node = new Node(data);
            // 先写根结点
            node.setLeft(create(input));
            node.setRight(create(input));
        }
        return node;
    }

    public static void main(String[] args) {
        // 1, 2, null, 3, null, null, 4, 5, null, null, null
        // 3, 2, 9, null, null, 10, null, null, 8, null, 4
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        Node root = create(input);
        TreeUtil.preOrder(root);
        System.out.println();
        TreeUtil.levelTravel(root);
    }
}
