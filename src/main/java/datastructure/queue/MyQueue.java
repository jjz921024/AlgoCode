package datastructure.queue;

/**
 * Created by Jun on 2017/4/10.
 */
public class MyQueue {
    /*Node front, rear; //头节点和尾节点

    public MyQueue(){
        //可以没有头节点，只定义头指针
        this.front = new Node(null);
        this.rear = this.front;
    }

    public void enQueue(Object a){
        // 只能从队尾入队
        this.rear.next = new Node(a); //新节点赋给当前队尾指针的后继
        this.rear = this.rear.next; //把新节点设成队尾

        // 第一个元素入队
        if (this.front.next == null){
            this.front.next = this.rear;
        }
    }

    public Object deQueue(){
        if (this.front == this.rear){
            System.out.println("queue is empty");
            return null;
        }
        Object result = this.front.next.data;
        if (this.front.next == this.rear){
            //只有一个节点
            this.rear = this.front;
            this.front.next = null;
        } else {
            this.front.next = this.front.next.next;
        }
        return result;
    }

    public void printQueue(){
        Node temp = this.front; //暂存头节点
        while (this.front != this.rear){
            System.out.print(this.front.hashCode()+":( " + this.front.data + "," + this.front.next.hashCode()+" ) | ");
            this.front = this.front.next;
        }
        System.out.println(this.front.hashCode()+":( " + this.front.data + "," + this.front.next+" ) | ");
        this.front = temp;
    }*/
}
