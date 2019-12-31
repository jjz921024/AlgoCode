package algo.linkedlist;

import datastructure.list.Node;

import javax.lang.model.element.VariableElement;


public class ListLoop {

    /**
     * 判断一个链表是否有环
     * 设置两个指针，分别以1和2的步长遍历链表，若相交则链表有环
     */
    public static boolean hasLoop(Node head) {
        Node p1 = head;
        Node p2 = head;
        // 注意循环条件
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 比较是否为同一元素
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 链表有环时，求环长
     * 当两指针第一次相遇时，继续循环前进
     * 当第二次相遇，统计循环次数，两指针速度差为1，再次相遇时，p2比p1多走1圈
     */
    public static int loopLength(Node head) {
        Node p1 = head;
        Node p2 = head;
        int length = 0;
        boolean isMeet = false;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (isMeet) {
                length++;
            }
            if (p1 == p2) {
                // 第二次相遇退出循环
                if (isMeet) {
                    break;
                }
                isMeet = true;
            }
        }
        return length;
    }

    /**
     * 返回入环结点
     * 设链表头结点到入环结点的距离为 D
     * 入环结点到首次相遇结点距离为 S1
     * 首次相遇结点回到入环结点距离为 S2
     * 首次相遇时，指针p2比p1多走一倍距离
     */
    public static Node getMeetNode(Node head) {
        return null;
    }


    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(2);
        Node n5 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        System.out.println(loopLength(n1));
    }
}
