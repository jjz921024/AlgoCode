package datastructure.tree;


import utils.node.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jun on 2017/6/19.
 * 自己实现的二叉树
 */
public class BinaryTree {

    /**
     * 通过先序遍历实现二叉树的序列化
     */
    public String serialByPre(BTreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 将一个字符串通过先序遍历反序列化成二叉树
     */
    public BTreeNode reconByPreString(String preStr) {
        String[] split = preStr.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return reconPreOrder(queue);
    }
    public BTreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        BTreeNode head = new BTreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }


    /**
     * 递归方法的 先序、中序、后序遍历
     */
    public void preOrder(BTreeNode head) {
        if (head == null)
            return;
        System.out.print(head.val + "!");
        preOrder(head.left);
        preOrder(head.right);
    }
    public void inOrder(BTreeNode head) {
        if (head == null)
            return;
        inOrder(head.left);
        System.out.print(head.val + "!");
        inOrder(head.right);
    }
    public void posOrder(BTreeNode head) {
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
    public void preOrderUnRecur(BTreeNode head) {
        Stack<BTreeNode> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            while (!stack.isEmpty()) {
                BTreeNode cur = stack.pop();
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
     * 先压入左子树，再压入右子树
     */
    public void inOrderUnRecur(BTreeNode head) {
        Stack<BTreeNode> stack = new Stack<>();
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
    public void levelTravel(BTreeNode head) {
        if (head == null)
            return;
        LinkedList<BTreeNode> queue = new LinkedList<>();
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
    public void deepTravel(BTreeNode head) {
        if (head == null)
            return;
        Stack<BTreeNode> stack = new Stack<>();
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




    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTreeNode head = binaryTree.reconByPreString("1!2!#!3!#!#!4!5!#!#!#!");
        System.out.println(binaryTree.serialByPre(head));

        binaryTree.inOrder(head);
        System.out.println();
        binaryTree.inOrderUnRecur(head);

        binaryTree.levelTravel(head);
        binaryTree.deepTravel(head);
    }
}
