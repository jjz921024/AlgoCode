import algo.list.ReverseList;
import structure.list.LinkedList;
import utils.Node;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private static LinkedList linkedList;

    @BeforeClass
    public static void init() {
        linkedList = new LinkedList(10);
    }

    @Test
    public void testInsert() {
        ListUtil.print(linkedList.getHead());
        linkedList.insertHead(99);
        linkedList.insertTail(99);
        ListUtil.print(linkedList.getHead());

        linkedList.insert(3, 98);
        ListUtil.print(linkedList.getHead());

        System.out.println(linkedList.getNode(3));
    }


    @Test
    public void testDelete() {
        LinkedList linkedList = new LinkedList(10);
        ListUtil.print(linkedList.getHead());

        linkedList.deleteNode(0);
        ListUtil.print(linkedList.getHead());

        linkedList.deleteNode(99);
        ListUtil.print(linkedList.getHead());

        linkedList.deleteNode(1);
        ListUtil.print(linkedList.getHead());

        linkedList.deleteNode(2);
        ListUtil.print(linkedList.getHead());
    }

    @Test
    public void reverseTest() {
        ListUtil.print(linkedList.getHead());
        Node head = linkedList.getHead();
        Node node = head.next;

        //Node reverseNode = ReverseList.reverse2(node);

        // 哨兵结点重新指向反转的结点
        //head.next = reverseNode;
        ListUtil.print(head);
    }


    @Test
    public void reverseTest2() {
        Node head = linkedList.getHead();
        ListUtil.print(head);
        //ReverseList.reversePartList(head, 2, 5);
        ListUtil.print(head);
    }
}
