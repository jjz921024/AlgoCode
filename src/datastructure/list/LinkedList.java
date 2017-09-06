package datastructure.list;

import org.junit.Test;
import utils.Node;
import java.util.Random;

/**
 * Created by Jun on 2017/4/8.
 */

public class LinkedList {
    public Node head;

    /*创建长度为n的链表，值随机*/
    public void create(int n){
        Random r = new Random();
        head = new Node(r.nextInt(10));
        Node node = head;
        for (int i=0; i<n-1; i++){
            node.next = new Node(r.nextInt(10));
            node = node.next;
        }
    }

    /*根据传入数组的值创建链表*/
    public void createFromArray(int[] array) {
        if (array == null) {
            return;
        }
        head = new Node(array[0]);
        Node tmp = head;
        for (int i=1; i<array.length; i++) {
            tmp.next = new Node(array[i]);
            tmp = tmp.next;
        }
    }

    /*在尾部插入一个值为a的节点*/
    public void insertTail(int a){
        if (head == null) {
            head = new Node(a);
        } else  {
            Node tmp = head.next;
            Node pre = head;
            while (tmp != null) {
                //记录前一个节点
                pre = tmp;
                tmp = tmp.next;
            }
            pre.next = new Node(a);
        }
    }

    /*在头部插入一个值为a的节点*/
    public void insertHead(int a) {
        if (head == null) {
            head = new Node(a);
        } else {
            Node node = new Node(a);
            node.next = head;
            head = node;
        }
    }

    /*返回第idx个节点的值*/
    public int getElem(int idx){
        if (head == null || idx <= 0) {
            System.out.println("get head==null or idx<=0");
            return -1;
        }
        Node tmp = head;
        while (tmp != null && (--idx != 0)){
            tmp = tmp.next;
        }
        if (tmp == null){
            System.out.println("get: idx beyoung linkedlist length");
            return -1;
        }
        System.out.println("the value is " + tmp.val + " @"+tmp.hashCode());
        return tmp.val;
    }

    /*在第idx个节点之前插入值为a的节点*/
    public void insert(int idx, int a){
        if (head == null || idx <= 0) {
            System.out.println("insert head==null or idx<=0");
            return;
        } else if (idx == 1) {
            Node tmp = new Node(a);
            tmp.next = head;
            head = tmp;
            return;
        }

        Node pre = head;
        Node tmp = head.next;
        while (tmp != null && (--idx > 1)){ //找到第idx节点的前一个
            pre = tmp;
            tmp = tmp.next;
        }
        if (tmp == null){
            System.out.println("insert: idx beyoung linkedlist length");
            return;
        }
        Node node = new Node(a);
        node.next = tmp;
        pre.next = node;
    }

    /**
     * 删除第idx个节点
     * 头节点为第一个节点
     */
    public void deleteElem(int idx){
        if (head == null || idx <= 0) {
            System.out.println("delete head==null or idx<=0");
            return;
        } else if (idx == 1) {
            //删除第一个节点，直接将头节点指向第二个节点
            head = head.next;
            return;
        }

        Node pre = head;
        Node tmp = head.next;
        while (tmp != null && (--idx > 1)){ //从第二个节点开始遍历
            pre = tmp;
            tmp = tmp.next;
        }
        if (tmp == null){
            System.out.println("delete: idx beyoung linkedlist length");
            return;
        }
        pre.next = tmp.next;
    }

    public void print(){
        Node node = head;
        while (node != null) {
            System.out.print(node.hashCode()+": (" + node.val + "," + (node.next == null ? null : node.next.hashCode()) +")" + " ==> ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     *  打印环形链表
     */
    public void printRound(){
        Node node = head;
        System.out.print(node.hashCode()+": (" + node.val + "," + (node.next == null ? null : node.next.hashCode()) +")" + " ==> ");
        node = node.next;
        while (node != null && node != head) {
            System.out.print(node.hashCode()+": (" + node.val + "," + (node.next == null ? null : node.next.hashCode()) +")" + " ==> ");
            node = node.next;
        }
        System.out.println();
    }

    public void clear(){
        head = null;
    }

    /**
     * 反转链表
     */
    public void reverse() {
        Node prev = null;
        while(head!=null){
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        head = prev;
    }

    @Test
    public void test(){
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,2,3,4,5});
        linkedList.print();
        linkedList.insertHead(11);
        linkedList.print();
        linkedList.insertTail(12);
        linkedList.print();
    }
}
