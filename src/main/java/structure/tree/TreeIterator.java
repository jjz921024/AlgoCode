package structure.tree;

import utils.TreeNode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class TreeIterator {

    /**
     * 递归方式
     * 先序、中序、后序遍历
     */
    public static void preOrder(TreeNode head) {
        if (head == null)
            return;
        // 结点打印顺序 根左右
        System.out.print(head.getValue() + " ");
        preOrder(head.getLeft());
        preOrder(head.getRight());
    }

    public static void inOrder(TreeNode head) {
        if (head == null)
            return;
        inOrder(head.getLeft());
        System.out.print(head.getValue() + " ");
        inOrder(head.getRight());
    }

    public static void posOrder(TreeNode head) {
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
    public static void preOrder2(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
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
    public static void inOrder2(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
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
    public static void posOrder2(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        // 再利用一个栈保存遍历结果
        Stack<Integer> result = new Stack<>();
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            // 根节点最后输出
            result.push(cur.getValue());

            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
        }
        // 输出结果
        while (!result.empty()) {
            System.out.println(result.pop());
        }
        System.out.println();
    }

    /**
     * 层次遍历 / 宽度优先遍历
     * 利用队列
     * 左孩子下标： 2 * parent + 1
     * 右孩子下标： 2 * parent + 2
     */
    public static void levelTravel(TreeNode head) {
        if (head == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
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



    List<List<Integer>> levels = new ArrayList<>();

    // 层次遍历，逐层返回二维数组
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        // 多加一层
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        // 获取当层的数组，添加数据
        levels.get(level).add(node.val);

        // 左右节点是下一层
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

}
