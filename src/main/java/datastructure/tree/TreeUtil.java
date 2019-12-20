package datastructure.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class TreeUtil {

    /**
     * 递归方法的 先序、中序、后序遍历
     */
    public static void preOrder(Node head) {
        if (head == null)
            return;
        System.out.print(head.val + "!");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(Node head) {
        if (head == null)
            return;
        inOrder(head.left);
        System.out.print(head.val + "!");
        inOrder(head.right);
    }

    public static void posOrder(Node head) {
        if (head == null)
            return;
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + "!");
    }

    /**
     * 非递归方法实现前序遍历
     * 利用栈，先压入右孩子，再压左孩子
     */
    public static void preOrder2(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.print(cur.val + "!");
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
            System.out.println();
        }
    }

    /**
     * 非递归方法的中序遍历
     * 先压入左子树，再压入右子树  todo 缺后序
     */
    public static void inOrder2(Node head) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + "!");
                head = head.right;
            }
        }
        System.out.println();
    }


    /**
     * 层次遍历，宽度优先遍历
     * 利用队列
     */
    public static void levelTravel(Node head) {
        if (head == null)
            return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null)
                queue.offer(head.left);
            if (head.right != null)
                queue.offer(head.right);
            System.out.print(head.val + "!");
        }
        System.out.println();
    }

    /**
     * 深度优先遍历， 优先走完一条分支左侧的节点
     * 利用栈，先压右节点，再压左节点
     */
    public static void deepTravel(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
            System.out.print(head.val + "!");
        }
        System.out.println();
    }
}
