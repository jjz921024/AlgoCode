package datastructure.tree;


import datastructure.queue.Queue;

/**
 * Created by Jun on 2017/6/19.
 */
public class BinaryTree {
    int[] data = new int[]{1,2,3,0,4,0,5};
    int count = 0;

    public BinaryTreeNode createBiTree(BinaryTreeNode tn, int[] data) {
        if (data != null && count < data.length) {
            if (data[count] == 0) {
                return null;
            } else {
                tn.value = data[count++];
                BinaryTreeNode lnode = new BinaryTreeNode();
                BinaryTreeNode rnode = new BinaryTreeNode();

                tn.lnode = createBiTree(lnode, data);
                tn.rnode = createBiTree(rnode, data);
            }
        }
        return tn;
    }

    public void breadthFirstTravel(BinaryTreeNode tn) {
        Queue queue = new Queue(50);

        queue.enQueue(tn.value);
        while (queue.getQueueLength() != 0) {
            
        }
    }
}
