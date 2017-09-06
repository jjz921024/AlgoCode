package question.linkedlist;

import datastructure.list.LinkedList;
import utils.Node;

/**
 * Created by Jun on 2017/8/2.
 */
public class ReverseList {

    /**
     * 反转单链表
     */
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


    /*public static Node reversePartList(Node head, int from, int to) {
        int len = 0;
        Node fPre = null;
        Node fPos = null;
        Node cur = head;
        // 找from前一个节点和to后一个节点
        while (cur != null) {
            len++;
            fPre = (len == from - 1) ? cur : fPre;
            fPos = (len == to + 1) ? cur : fPos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }


    }*/

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
