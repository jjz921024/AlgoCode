package question.linkedlist;

import datastructure.list.LinkedList;
import utils.Node;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 */
public class Palindrome {
    /**
     *  将链表转成数组
     *  该方法不推荐  空间复杂度为0(n)
     */
    public static boolean isPalindrome1(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int i = arr.size();
        int k = i;
        for (int j=0; j<i/2; j++) {
            if (arr.get(j).intValue() != arr.get(--k).intValue())
                return false;
        }
        return true;
    }

    /**
     * 利用栈，将链表压入栈中，再依次弹出对比
     * 空间复杂度0(n)
     */
    public static boolean isPalindrome2(Node head) {
        Stack<Integer> stack = new Stack<Integer>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (head != null && !stack.isEmpty()) {
            if (stack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 只将一半的链表入栈，节省一半空间
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null)
            return true;
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            right = right.next;
        }
        Stack<Integer> stack = new Stack<>();
        // 链表右边入栈
        while (right != null) {
            stack.push(right.val);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 空间复杂度 0(1) 解法
     */
    public static boolean isPalindrome4(Node head) {
        return Boolean.parseBoolean(null);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,2,3,2,1,3});
        linkedList.print();

        System.out.println(isPalindrome1(linkedList.head));
        System.out.println(isPalindrome2(linkedList.head));
        System.out.println(isPalindrome3(linkedList.head));
    }
}