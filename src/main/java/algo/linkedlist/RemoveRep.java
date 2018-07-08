package algo.linkedlist;

import datastructure.list.LinkedList;
import utils.node.Node;

import java.util.HashSet;

/**
 * Created by Jun on 2017/8/28.
 * 删除单链表中值重复出现的节点
 */
public class RemoveRep {

    /**
     * 利用哈希表
     * 时间复杂度为0(n),空间复杂度为0(n)
     */
    public static void removeRep1(Node head) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        Node pre = head;
        head = head.next;

        while (head != null) {
            if (hashSet.contains(head.val))
                pre.next = head.next;
            else {
                hashSet.add(head.val);  // TODO: 2017/8/28 同JosephusKill
                pre = pre.next;
            }
            head = head.next;
        }
    }

    /**
     * 类似选择排序
     * 空间复杂度0(1)，时间复杂度0(n*n)
     */
    public static void removeRep2(Node head) {
        Node cur = head;  // 这一次循环的基准
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.val != next.val)
                    pre.next = next.next;
                else
                    pre = next;   // TODO: 2017/8/28 同JosephusKill
                next = next.next;
            }
            cur = cur.next;   // 取下一个要比较的节点
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,1});
        linkedList.print();

        removeRep1(linkedList.head);
        linkedList.print();
    }
}
