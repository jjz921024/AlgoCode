package algo.linkedlist;

import datastructure.list.Node;

/**
 * Created by Jun on 2017/8/2.
 */
public class ReverseList {

    // 反转单链表
    public static Node reverse(Node node) {
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            // 当前头节点的next 改成指向 前一个节点prev
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // 递归翻转链表
    public static Node reverse2(Node node) {
        if (node.next == null) {
            return node;
        }

        // 先翻转node结点之后的链表
        Node newHead = reverse2(node.next);

        // 再把原 node 节点后继结点的后继结点指向 node，node 的后继节点设置为空(防止形成环)
        node.next.next = node;
        node.next = null;

        // 返回翻转后的头结点
        return newHead;
    }


    // 翻转从from到to的结点
    public static void reversePartList(Node node, int fromIndex, int toIndex) {
        Node fromPre = null;
        Node from = null;
        Node to = null;
        Node toNext = null;

        // 确认fromPre，from，to，toNext四个结点
        // 哨兵结点的index为0，index从1开始
        int curIndex = 1;
        Node tmp = node.next;
        while (tmp != null) {
            if (curIndex == fromIndex - 1) {
                fromPre = tmp;
            } else if (curIndex == fromIndex) {
                from = tmp;
            } else if (curIndex == toIndex) {
                to = tmp;
            } else if (curIndex == toIndex + 1) {
                toNext = tmp;
            }
            tmp = tmp.next;
            curIndex++;
        }

        // from 或 to 都超过尾结点不翻转
        if (from == null || to == null) {
            throw new RuntimeException("不符合条件");
        }

        // 翻转from到to区间的结点
        Node pre = from;
        Node cur = pre.next;
        while (cur != toNext) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 将 from-1 节点指向 to 结点
        // 如果from-1结点为空，哨兵结点指向to
        if (fromPre != null) {
            fromPre.next = to;
        } else {
            node.next = to;
        }
        // 将 from 结点指向 to + 1 结点
        from.next = toNext;
    }

}
