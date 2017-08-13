package datastructure.list;

import org.junit.Test;
import utils.Node;

import java.util.Random;

/**
 * Created by Jun on 2017/4/8.
 */
public class CircularLinkedList{
    private Node head;

    public void create(int n) {
        Random r = new Random();
        head = new Node(r.nextInt(10));

        Node node = head;
        for (int i=0; i<n-1; i++){
            node.next = new Node(r.nextInt(10));
            node = node.next;
        }
        node.next = head; //最后一个节点指向头节点
    }

    /*public void createListTail(int n) {
        head = new Node(n);
        Random r = new Random();

        Node tail = head; //传引用
        for (int i=0; i<n; i++){
            Node p = new Node(r.nextInt(10));
            tail.next = p;  //表尾节点指针指向新节点
            tail = p;       //将新节点设为表尾节点
        }
        tail.next = head; //最后一个节点指向头节点
    }*/


    public void print(){
        Node tmp = head;
        while (tmp.next != head){
            System.out.print(tmp.hashCode()+": (" + tmp.val + "," + tmp.next.hashCode() +")" + " ==> ");
            tmp = tmp.next;
        }
        System.out.print(tmp.hashCode()+": (" + tmp.val + "," + tmp.next.hashCode() +")" + " ==> ");
        System.out.println();
    }

    @Test
    public void test() {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.create(5);
        circularLinkedList.print();
    }
}
