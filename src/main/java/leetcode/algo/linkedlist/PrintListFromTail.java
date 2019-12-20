package leetcode.algo.linkedlist;
import datastructure.list.LinkedList;
import datastructure.list.Node;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by Jun on 2017/8/2.
 * 从尾到头打印链表
 */
public class PrintListFromTail {

    /**
     * 递归方法，把链表从尾到头依次添加进数组
     * 打印数组
     */
    private static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead1(Node listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    /**
     * 将链表依次入栈，再将栈依次弹出
     */
    public static ArrayList<Integer> printListFromTailToHead2(Node listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 递归打印
     */
    public static void printListFromTailToHead3(Node listNode) {
        if (listNode != null) {
            printListFromTailToHead3(listNode.next);
            System.out.print(listNode.val + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,2,3,4,5});
        linkedList.print();

        printListFromTailToHead3(linkedList.head);
    }
}
