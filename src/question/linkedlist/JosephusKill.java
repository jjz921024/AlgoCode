package question.linkedlist;

import utils.Node;

/**
 * Created by Jun on 2017/8/12.
 */
public class JosephusKill {
    public Node josephusKill(Node head, int m) {
        if (head == null || m < 1 || head.next == head) {  //只有一个节点
             return head;
        }

        return null;
    }
}
