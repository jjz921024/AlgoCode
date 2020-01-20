package algo.list;

import utils.Node;

/**
 * Created by Jun on 2017/8/28.
 * 约瑟夫问题
 */
public class JosephusKill {
    /**
     * 时间复杂度 0(m*n)
     */
    public static Node josephusKill1(Node head, int m) {
        if (head == null || m < 1 || head.next == head) {   //只有一个节点的情况
            return head;
        }

        // 找头节点的前一个节点
        Node pre = head;
        while (pre.next != head) {
            pre = pre.next;
        }

        // 环形链表，直到链表中只有一个节点为止
        int i = 0;
        while (head.next != head) {
            if (++i == m) {
                pre.next = head.next;
                i = 0;
            } else {
                pre = pre.next;  // TODO: 2017/8/28 删除节点后，pre不应再往前走
            }
            head = head.next;
        }
        return head;
    }

    /*public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createFromArray(new int[]{1,2,3,4,5});
        TreeNode head = linkedList.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = linkedList.head;
        linkedList.printRound();

        linkedList.head = josephusKill1(linkedList.head, 3);
        linkedList.printRound();
    }*/
}
