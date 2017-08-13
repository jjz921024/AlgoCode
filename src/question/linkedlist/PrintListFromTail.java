package question.linkedlist;
import utils.Node;

import java.util.ArrayList;
import java.util.Stack;


/**
 * https://www.nowcoder.com/questionCenter?questionTypes=000100&mutiTagIds=580
 * Created by Jun on 2017/8/2.
 *
 *  从尾到头打印链表
 *  https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035?orderByHotValue=1&questionTypes=000100&mutiTagIds=580&page=1&onlyReference=false
 */
public class PrintListFromTail {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }


    //栈
    public ArrayList<Integer> printListFromTailToHead1(Node listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (!stack.empty()) {
            integers.add(stack.pop());
        }
        return integers;
    }
}
