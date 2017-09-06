package question.linkedlist;

import datastructure.list.LinkedList;
import utils.Node;

/**
 * Created by Jun on 2017/8/24.
 */
public class PrintCommonPart {

    /**
     * 打印两个有序链表的公共部分， 值相同的部分
     */
    public static void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {  //error
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;  //error
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        // for test printCommonPart
        /*LinkedList head1 = new LinkedList();
        head1.createFromArray(new int[]{1,2,3,4,5});
        head1.print();
        LinkedList head2 = new LinkedList();
        head2.createFromArray(new int[]{1,2,5,6,9});
        head2.print();

        printCommonPart(head1.head, head2.head);*/

    }
}





