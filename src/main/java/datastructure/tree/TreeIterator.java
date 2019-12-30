package datastructure.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class TreeIterator {

    /**
     * 递归方式
     * 先序、中序、后序遍历
     */
    public static void preOrder(Node head) {
        if (head == null)
            return;
        // 结点打印顺序 根左右
        System.out.print(head.getValue() + " ");
        preOrder(head.getLeft());
        preOrder(head.getRight());
    }

    public static void inOrder(Node head) {
        if (head == null)
            return;
        inOrder(head.getLeft());
        System.out.print(head.getValue() + " ");
        inOrder(head.getRight());
    }

    public static void posOrder(Node head) {
        if (head == null)
            return;
        posOrder(head.getLeft());
        posOrder(head.getRight());
        System.out.print(head.getValue() + " ");
    }

    /**
     * 非递归方式，前序遍历
     * 利用栈，先压入右孩子，再压左孩子
     */
    public static void preOrder2(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            // 先打印根结点
            System.out.print(cur.getValue() + " ");
            // 先后压入右孩子和左孩子， 根左右，先入后出
            if (cur.getRight() != null)
                stack.push(cur.getRight());
            if (cur.getLeft() != null)
                stack.push(cur.getLeft());
        }
        System.out.println();
    }

    /**
     * 非递归方法， 中序遍历
     * 先压入左子树，再压入右子树
     */
    public static void inOrder2(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 先把所有左孩子压入栈中
                stack.push(head);
                head = head.getLeft();
            } else {
                // 左孩子为空时，打印根结点
                // 打印顺序 左中右
                head = stack.pop();
                System.out.print(head.getValue() + " ");
                // 若有右孩子，则会将右孩子也入栈，然后再打印出来
                head = head.getRight();
            }
        }
        System.out.println();
    }

    /**
     * 非递归方法， 后序遍历
     */
    public static void posOrder2(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        LinkedList<Integer> list = new LinkedList<>();
        while (!stack.empty()) {
            Node cur = stack.pop();
            list.addFirst(cur.getValue());

            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
        }
        System.out.println(list.toString());
    }

    /**
     * 层次遍历 / 宽度优先遍历
     * 利用队列
     * 左孩子下标： 2 * parent + 1
     * 右孩子下标： 2 * parent + 2
     */
    public static void levelTravel(Node head) {
        if (head == null)
            return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            // 左右孩子依次入队列
            if (head.getLeft() != null)
                queue.offer(head.getLeft());
            if (head.getRight() != null)
                queue.offer(head.getRight());
            System.out.print(head.getValue() + " ");
        }
        System.out.println();
    }

}
