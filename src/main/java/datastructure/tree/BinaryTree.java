package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树实现
 */
public class BinaryTree {

    /**
     * 通过先序遍历实现二叉树的序列化
     */
    public String serializeByPre(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    /**
     * 将一个字符串通过先序遍历反序列化成二叉树
     */
    public Node deserializeByPre(String str) {
        String[] split = str.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return reconPreOrder(queue);
    }

    public Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }




    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node head = binaryTree.deserializeByPre("1!2!#!3!#!#!4!5!#!#!#!");
        System.out.println(binaryTree.serializeByPre(head));
    }
}
