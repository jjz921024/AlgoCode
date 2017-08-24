package question.linkedlist;

import utils.Node;
import java.util.ArrayList;

/**
 * 判断一个链表是否是回文结构
 */
public class Palindrome {
    /**
     *  将链表转成数组
     *  该方法不推荐  空间复杂度为0(n)
     */
    public boolean isPalindrome1(Node pHead) {
        ArrayList<Integer> val = new ArrayList<Integer>();
        while (pHead != null) {
            val.add(pHead.val);
            pHead = pHead.next;
        }

        int i = val.size();
        int k =i;
        for (int j=0; j<i/2; j++) {
            if (val.get(j).intValue() != val.get(--k).intValue())
                return false;
        }
        return true;
    }

}