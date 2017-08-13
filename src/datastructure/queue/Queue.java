package datastructure.queue;

/**
 * 循环队列  顺序存储结构
 * Created by Jun on 2017/4/9.
 */
public class Queue {
    private Object[] data;
    private int front;
    private int rear;

    public Queue(int n){
        this.data = new Object[n];
        this.front = 0;
        this.rear = 0;
    }

    public int getQueueLength(){
        return (this.rear - this.front + this.data.length) % this.data.length;
    }

    public void enQueue(Object a){
        //队列满时，保留一个数据空间
        if ((this.rear + 1) % this.data.length == this.front){
            System.out.println("queue is full");
            return;
        }
        //队尾指针指向队尾元素的下一个位置
        this.data[this.rear] = a;
        //可循环
        this.rear = (this.rear + 1) % this.data.length;
    }

    public Object deQueue(){
        if (this.rear == this.front){
            System.out.println("queue is empty");
            return null;
        }
        Object result = this.data[this.front];
        this.data[this.front] = null; //清空
        this.front = (this.front + 1) % this.data.length;
        return result;
    }

    public void printQueue(){
        for (int i = 0; i < this.data.length; i++){
            System.out.print(this.data[i]);
            if (i == this.front){
                System.out.print("(front)");
            } else if (i == this.rear){
                System.out.print("(rear)");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }
}
