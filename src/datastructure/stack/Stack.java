package datastructure.stack;

/**
 * Created by Jun on 2017/4/9.
 */
public class Stack {
    private Object[] data = null;  //下标为0的是栈底
    private int top = -1;

    public Stack(int n) {
        if (n < 0){
            System.out.println("init stack error");
        }
        data = new Object[n];
    }

    public void push(Object o){
        if (top == data.length - 1){
            System.out.println("stack is full");
            return;
        }
        data[++top] = o;
    }

    public Object pop(){
        if (top == -1){
            System.out.println("stack is empty");
            return null;
        }
        return data[top--];
    }

    public Object getTopElem(){
        if (top == -1){
            System.out.println("stack is empty");
            return null;
        }
        System.out.println("the top element is " + data[top]);
        return data[top];
    }

    public int isStackEmpty(){
        if (top == -1){
            System.out.println("stack is empty");
            return 1;
        } else {
            System.out.println("stack is not empty");
            return 0;
        }
    }

    public int getStackLength(){
        int length = top + 1;
        System.out.println("the length of this stack is " + length);
        return length;
    }

    public void clearStack(){
        data = new Object[data.length];
        top = -1;
    }

    public void printStack(){
        System.out.print("bottom | ");
        for (int i = 0; i <= top; i++){
            System.out.print(data[i] + " | ");
        }
        System.out.println(" top");
    }
}
