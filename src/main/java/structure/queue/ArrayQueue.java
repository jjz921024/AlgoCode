package structure.queue;

import java.util.Random;

/**
 * Created by Jun on 2017/4/9.
 * 队列，维护一个可循环的数组
 * 数组长度为n时，队列可添加n-1个元素
 *
 * 当头指针和尾指针重叠时，队列为空
 * 当尾指针在头指针前一个位置时，队列为满
 */
public class ArrayQueue {
    private Integer[] data;
    private int head = 0;   //队列头指针，指向队列的第一个元素
    private int tail = 0;   //队列尾指针，指向队列最后一个元素的下一个位置

    public ArrayQueue(int n){
        if (n < 0){
            System.out.println("n must > 0");
        }
        this.data = new Integer[n];
    }

    // 随机创建一个长度为n的队列
    public void creatQueueRamdom(int n) {
        Random random = new Random();
        for (int i=0; i<n; i++) {
            this.enQueue(random.nextInt(10));
        }
    }

    public void enQueue(Integer a){
        //队列满时，保留一个数据空间
        //区分队列为空 还是 满
        if ((tail + 1) % data.length == head){
            System.out.println("queue is full");
            return;
        }
        //队尾指针指向队尾元素的下一个位置
        data[tail] = a;
        //可循环
        tail = (tail + 1) % data.length;
    }

    public Integer deQueue(){
        if (tail == head){
            System.out.println("queue is empty");
            return null;
        }
        Integer result = data[head];
        data[head] = null; //清空
        head = (head + 1) % data.length;
        return result;
    }

    public int getQueueLength(){
        return (tail - head + data.length) % data.length;
    }

    public void printQueue(){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            if (i == head){
                System.out.print("(front)");
            } else if (i == tail){
                System.out.print("(rear)");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue myQueue = new ArrayQueue(10);
        myQueue.creatQueueRamdom(9);
        myQueue.printQueue();
        myQueue.deQueue();
        myQueue.printQueue();
    }
}
