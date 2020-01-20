package algo.list;

import utils.Node;

import java.util.Stack;

/**
 * Created by Jun on 2017/8/28.
 * 相加链表
 */
public class AddLists {

    /**
     * 利用栈结构
     */
    public static Node addList1(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }

        Node head = null;
        Node pre = null;
        int ca = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            int n = n1 + n2 + ca;
            ca = n / 10;

            pre = head;  // 头插法
            head = new Node(n % 10);
            head.next = pre;
        }
        if (ca == 1) {
            pre = head;
            head = new Node(1);
            head.next = pre;
        }
        return head;
    }

    /**
     * 将链表倒序相加
     */
    public static Node addList2(Node head1, Node head2) {
        Node node1 = ReverseList.reverse(head1);
        Node node2 = ReverseList.reverse(head2);

        int ca = 0;
        Node head = null;
        Node pre = null;
        while (node1 != null || node2 != null) {
            int n1 = node1==null ? 0 : node1.val;
            int n2 = node2==null ? 0 : node2.val;
            int n = n1 + n2 + ca;
            ca = n / 10;

            pre = head;
            head = new Node(n % 10);
            head.next = pre;

            node1 = node1==null ? null : node1.next;  // TODO: 2017/8/28
            node2 = node2==null ? null : node2.next;
        }
        if (ca == 1) {
            pre = head;
            head = new Node(1);
            head.next = pre;
        }
        return head;
    }


    /*public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.createFromArray(new int[]{1,2,3,4,5});
        LinkedList linkedList2 = new LinkedList();
        linkedList2.createFromArray(new int[]{1,2,3,4,5});

        LinkedList res1 = new LinkedList();
        LinkedList res2 = new LinkedList();
        res1.head = addList1(linkedList1.head, linkedList2.head);
        res2.head = addList2(linkedList1.head, linkedList2.head);
        res1.print();
        res2.print();
    }*/
}
