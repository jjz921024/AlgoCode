package question.linkedlist;

import datastructure.list.LinkedList;
import utils.Node;

/**
 * Created by Jun on 2017/8/2.
 * 工具类， 反转链表
 */
public class ReverseList {

    public static Node reverseList(Node head) {
        Node prev = null;
        Node next = null;
        while(head != null){
            next = head.next;
            // 当前头节点的next 改成指向 前一个节点prev
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,2,3,4,5});
        linkedList.print();

        linkedList.reverse();
        linkedList.print();

        linkedList.head = reverseList(linkedList.head);
        linkedList.print();
    }
}
