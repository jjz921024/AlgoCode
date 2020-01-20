package structure.stack;

/**
 * Created by Jun on 2017/4/9.
 * 自己实现的链栈
 */
class StackNode {
    Object data;
    StackNode next;

    public StackNode(Object data, StackNode next) {
        this.data = data;
        this.next = next;
    }
}
public class LinkedStack {
    private StackNode top;
    private int length; //链栈的长度

    public LinkedStack() {
        this.top = null;
        this.length = 0;
    }

    public void push(Object o){
        // 链栈不需要考虑是否溢出
        this.top = new StackNode(o, this.top);
        this.length++;
    }
    public Object pop(){
        if (this.top == null){
            System.out.println("the stack is empty");
        }
        StackNode result = this.top;  //要pop的节点
        this.top = result.next;   //向下移动栈顶指针
        this.length--;
        return result.data;
    }

    public void printLinkStack(){
        System.out.print("top | ");
        StackNode temp = this.top;  //遍历时会改变头节点，暂存
        for (int i = 0; i < this.length - 1; i++){
            System.out.print(this.top.hashCode() + "(" + this.top.data + " , "+ this.top.next.hashCode() + ") | ");
            this.top = this.top.next;
        }
        System.out.print(this.top.hashCode() + "(" + this.top.data + " , "+ this.top.next + ") | "); //尾节点
        System.out.println(" bottom");
        this.top = temp;
    }
}
