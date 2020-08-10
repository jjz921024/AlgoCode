package algo.list;

import utils.Node;


public class LoopList {

    /**
     * 判断一个链表是否有环
     * 设置两个指针，分别以1和2的步长遍历链表，若相交则链表有环
     * leetcode 141
     */
    public boolean hasLoop(Node head) {
        Node p1 = head;
        Node p2 = head;
        // 注意循环条件
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 比较是否为同一元素
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 链表有环时，求环长
     * 当两指针第一次相遇时，继续循环前进，当第二次相遇，统计环长
     * 两指针速度差为1，再次相遇时，p2比p1多走1圈
     */
    public int loopLength(Node head) {
        Node p1 = head;
        Node p2 = head;
        int length = 0;
        boolean isMeet = false;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (isMeet) {
                length++;
            }
            if (p1 == p2) {
                // 第二次相遇退出循环
                if (isMeet) {
                    break;
                }
                isMeet = true;
            }
        }
        return length;
    }

    /**
     * leetcode 142  若有环返回入环结点，无环返回null
     * 相遇时，将一个指针设为head，同速前进，再次相遇即为入环节点
     */
    public Node detectCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        boolean isMeet = false;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                isMeet = true;
                break;
            }
        }

        if (!isMeet) return null;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
