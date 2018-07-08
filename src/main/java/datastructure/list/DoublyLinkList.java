package datastructure.list;


import org.junit.Test;
import utils.node.DoublyNode;

import java.util.Random;

/**
 * Created by Jun on 2017/4/8.
 */
public class DoublyLinkList {
    private DoublyNode head;

    public void create(int n) {
        Random r = new Random();
        head = new DoublyNode(r.nextInt(10));

        DoublyNode tmp = head;
        for (int i=0; i<n-1; i++){
            DoublyNode node = new DoublyNode(r.nextInt(10));
            tmp.next = node;
            node.pre = tmp;
            tmp = tmp.next;
        }
    }


    public void print() {
        DoublyNode tmp = head;
        while (tmp != null){
            System.out.print(tmp.hashCode()+": (" + (tmp.pre == null ? null : tmp.pre.hashCode()) + ", " + tmp.val + " ,"+ (tmp.next == null ? null : tmp.next.hashCode()) +")" + " ==> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.create(5);
        doublyLinkList.print();
    }
}
