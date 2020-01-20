package structure.list;

import utils.Node;

/**
 * Created by Jun on 2017/8/13.
 */
public class DoublyNode extends Node {
    public DoublyNode next;
    public DoublyNode pre;

    public DoublyNode(int data) {
        super(data);
    }
}