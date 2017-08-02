import utils.ListNode;

import java.util.*;


public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        ArrayList<Integer> val = new ArrayList<Integer>();
        while (pHead != null) {  //todo 不是pHead.next != null
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