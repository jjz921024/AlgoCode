package question.linkedlist;

import datastructure.list.LinkedList;
import utils.Node;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/28.
 * 删除单链表中指定值的节点
 */
public class RemoveValue {
    /**
     * 利用栈
     * 注意：从栈连接成链表时是 头插
     */
    public static Node removeValue1(Node head, int a) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.val != a)
                stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }


    /**
     * 遍历直接判断
     * 空间复杂度0(1)
     */
    public static Node removeValue2(Node head, int a) {
        //注意：先找第一个不等于a的节点作为头节点
        while (head != null) {
            if (head.val != a)
                break;
            head = head.next;
        }
        Node pre = head;
        Node cur = head;  // 最好不要Node cur = head.next; 1个节点时会有空指针
        while (cur != null) {
            if (cur.val == a)
                pre.next = cur.next;
            else
                pre = cur;   // 不要pre=pre.next
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{5});
        linkedList.print();

        linkedList.head = removeValue2(linkedList.head, 5);
        linkedList.print();
    }
}
