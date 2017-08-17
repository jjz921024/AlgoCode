package datastructure.queue;

import utils.Node;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Jun on 2017/8/16.
 */
public class QueueExtend extends LinkedList{

    public void print(){
        System.out.print("tail | ");
        while (!this.isEmpty()) {
            System.out.print(this.pop() + " | ");
        }
        System.out.println("head");
    }

    public void pushFromRandom(int n) {
        Random random = new Random();
        while (n-- != 0)
            this.push(random.nextInt(10));
    }

    public void pushFromArray(int[] a) {
        for (int data : a)
            this.push(data);
    }

    public static void main(String[] args) {
        QueueExtend queueExtend = new QueueExtend();
        queueExtend.pushFromArray(new int[]{1,2,3,4,5});
        queueExtend.print();
    }
}
