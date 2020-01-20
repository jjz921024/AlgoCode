package utils;

public class ListUtil {

    public static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.val).append(" | ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

}
