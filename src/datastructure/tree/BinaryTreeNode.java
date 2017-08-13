package datastructure.tree;

/**
 * Created by Jun on 2017/6/19.
 */
public class BinaryTreeNode {
    int value;
    BinaryTreeNode lnode;
    BinaryTreeNode rnode;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.lnode = null;
        this.rnode = null;
    }

    public BinaryTreeNode() {
    }
}
