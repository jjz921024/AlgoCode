package algo.list;

import utils.Node;

import java.util.ArrayList;
import java.util.Stack;

public class PrintList {

    /**
     * 从尾到头打印链表
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


    /**
     * 打印两个有序链表的公共部分， 值相同的部分
     */
    public void printCommonPart(Node head1, Node head2) {
        while (head1.next != null && head2.next != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

}
