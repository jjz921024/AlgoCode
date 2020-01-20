package structure.stack;

/**
 * Created by Jun on 2017/4/9.
 * 自己实现的栈结构，底层是数组
 */
public class MyStack {
    private Integer[] data = null;  //下标为0的是栈底
    private int pointer = -1;   //栈顶指针，始终指向栈顶元素

    //初始化一个栈
    public MyStack(int n) {
        if (n < 0){
            System.out.println("n must > 0");
        }
        data = new Integer[n];
    }


    // 快速往栈中填入数据
    public void pushFromArray(Integer[] a){
        for (int i=0; i<a.length; i++) {
            this.push(a[i]);
        }
    }


    public void push(Integer a) {
        if (pointer == data.length - 1){
            System.out.println("stack is full");
        } else {
            data[++pointer] = a;
        }
    }

    public int pop(){
        if (pointer == -1){
            System.out.println("stack is empty");
            return -1;
        }
        return data[pointer--];
    }

    public int peek(){
        if (pointer == -1){
            System.out.println("stack is empty");
            return -1;
        }
        return data[pointer];
    }

    public boolean isEmpty(){
        if (pointer == -1) return true;
        else return false;
    }

    public int getStackLength(){
        int length = pointer + 1;
        return length;
    }

    public void print(){
        System.out.print("bottom | ");
        for (int i = 0; i <= pointer; i++){
            System.out.print(data[i] + " | ");
        }
        System.out.println(" top");
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.pushFromArray(new Integer[]{1,2,3,4,5,6});
        myStack.print();
    }
}
