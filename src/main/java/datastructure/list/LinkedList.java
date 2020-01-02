package datastructure.list;

import java.util.Random;

/**
 * Created by Jun on 2017/4/8.
 */

@SuppressWarnings("Duplicates")
public class LinkedList {

    private Node head = new Node(-1); // 哨兵节点

    // 创建长度为n的链表，值随机
    public LinkedList(int n) {
        Random r = new Random();
        Node temp = head;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(r.nextInt(100));
            temp = temp.next;
        }
    }

    // 据传入数组的值创建链表
    public LinkedList(int[] array) {
        if (array == null) {
            return;
        }
        Node temp = head;
        for (int i = 0; i < array.length; i++) {
            temp.next = new Node(array[i]);
            temp = temp.next;
        }
    }

    /* 有虚拟头结点，不用判空
    if (head == null) {
        head = new Node(a);
    }*/
    // 尾插法：在尾部插入一个值为a的节点
    public void insertTail(int a) {
        Node temp = head;
        // 用于遍历的临时结点的next为空表示到尾部
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(a);
    }

    // 头插法：在头部插入一个值为a的节点
    public void insertHead(int a) {
        Node node = new Node(a);
        node.next = head.next;
        head.next = node;
    }

    // 在第idx个节点之前插入值为a的节点
    public void insert(int idx, int a) {
        if (idx <= 0) {
            return;
        }

        Node pre = head;
        Node temp = head.next;
        while (temp != null && idx-- > 1) {
            pre = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        Node node = new Node(a);
        node.next = temp;
        pre.next = node;
    }

    // 删除第idx个节点，哨兵节点为第一个结点, 下标0
    public void deleteNode(int idx) {
        if (idx <= 0) {
            return;
        }

        Node pre = head;
        Node temp = head.next;
        // idx为1时，直接将head指向next的next
        while (temp != null && idx-- > 1) {
            pre = temp;
            temp = temp.next;
        }
        // idx比链表长时
        if (temp == null) {
            return;
        }
        pre.next = temp.next;
    }

    // 返回第idx个节点的值
    public int getNode(int idx) {
        if (idx <= 0) {
            return -2;
        }
        Node tmp = head;
        while (tmp != null && idx-- > 0) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return -2;
        }
        return tmp.val;
    }



    public Node getHead() {
        return head;
    }


    // 打印环形链表
    /*public void printRound() {
        Node node = head;
        System.out.print(node.hashCode() + ": (" + node.val + "," + (node.next == null ? null : node.next.hashCode()) + ")" + " ==> ");
        node = node.next;
        while (node != null && node != head) {
            System.out.print(node.hashCode() + ": (" + node.val + "," + (node.next == null ? null : node.next.hashCode()) + ")" + " ==> ");
            node = node.next;
        }
        System.out.println();
    }*/

}
