import utils.ListNode;

import java.util.ArrayList;

/**
 * Created by Jun on 2017/7/31.
 */



public class InvertList {
    public ListNode FindKthToTail(ListNode head, int k) {
        ArrayList<ListNode> tmp = new ArrayList<>();
        if (head == null) return null;
        else {
            while (head != null) {
                tmp.add(head);
                head = head.next;
            }
        }
        if (tmp.size() < k) return null;
        else if (k == 0) return null;
        return tmp.get(tmp.size() - k);
    }


    public boolean removeNode(ListNode pNode) {
        ListNode tmp = pNode;
        pNode = pNode.next;
        return tmp.next == null ? false : true;
    }
}
