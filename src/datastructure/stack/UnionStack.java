package datastructure.stack;

/**
 * Created by Jun on 2017/4/9.
 */
public class UnionStack {
    private Object[] data;
    private int top1;
    private int top2;

    public UnionStack(int n){
        this.data = new Object[n];
        this.top1 = -1;
        this.top2 = n;  //栈2为空时 top2=n
    }

    public void push(Object a, int n){
        if (this.top1 + 1 == this.top2){
            //两栈指针相差1
            System.out.println("stack is full");
            return;
        }
        if (n == 1){
            // 入栈1
            data[++top1] = a;
        } else if (n == 2){
            data[--top2] = a;
        } else {
            System.out.println("num is error");
        }
    }

    public Object pop(int n){
        Object resule = null;
        if (n == 1){
            if (top1 == -1){
                System.out.println("stack1 is full");
                return null;
            }
            resule = data[top1];
            data[top1--] = null;
            return resule;
        } else if (n == 2){
            if (top2 == n){
                System.out.println("stack2 is full");
                return null;
            }
            resule = data[top2];
            data[top2--] = null;
            return resule;
        } else {
            System.out.println("num is error");
            return null;
        }
    }

    public void printStack(){
        for (int i = 0; i < this.data.length; i++){
            System.out.print(this.data[i] + " | ");
        }
        System.out.println();
    }
}
