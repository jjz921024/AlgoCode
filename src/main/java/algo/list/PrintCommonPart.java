package algo.list;

import utils.Node;

/**
 * Created by Jun on 2017/8/24.
 * todo
 */
public class PrintCommonPart {

  /**
   * 打印两个有序链表的公共部分， 值相同的部分
   */
  public void printCommonPart(Node head1, Node head2) {
    while (head1 != null && head2 != null) {  //error
      if (head1.val < head2.val) {
        head1 = head1.next;
      } else if (head1.val > head2.val) {
        head2 = head2.next;
      } else {
        System.out.println(head1.val);
        head1 = head1.next;  //error
        head2 = head2.next;
      }
    }
  }

}





