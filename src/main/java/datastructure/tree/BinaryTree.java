package datastructure.tree;

import java.util.*;

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

    // 由层次遍历构建完全二叉树
    // 完全二叉树可以一数组完全确定, int数组不存在null元素
    public static Node create(Integer[] input) {
        if (input == null || input.length <= 0) {
            return null;
        }

        LinkedList<Integer> queue = new LinkedList<>(Arrays.asList(input));
        LinkedList<Node> rootQueue = new LinkedList<>();

        Node root = new Node(queue.poll());
        rootQueue.add(root);

        while (!rootQueue.isEmpty()) {
            Node node = rootQueue.poll();
            if (!queue.isEmpty()) {
                node.setLeft(new Node(queue.poll()));
                rootQueue.add(node.getLeft());
            }
            if (!queue.isEmpty()) {
                node.setRight(new Node(queue.poll()));
                rootQueue.add(node.getRight());
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // 1, 2, null, 3, null, null, 4, 5, null, null, null
        // 3, 2, 9, null, null, 10, null, null, 8, null, 4
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        Node root = create(input);
        TreeIterator.preOrder(root);
        System.out.println();
        TreeIterator.levelTravel(root);

        Integer[] array = new Integer[]{1, 3, 4, 6, 7};
        Node node = create(array);
        TreeIterator.levelTravel(node);
    }
}
