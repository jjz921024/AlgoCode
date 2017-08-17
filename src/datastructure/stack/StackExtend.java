package datastructure.stack;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Jun on 2017/8/16.
 */
public class StackExtend extends Stack{

    public void print() {
        System.out.print("bottom | ");
        for (Object o : elementData) {
            System.out.print(o + " | ");
        }
        System.out.println("top");
    }

    // 按数组内容快速往栈中填入数据
    public void pushFromArray(Integer[] a){
        for (Integer anA : a) {
            push(anA);
        }
    }

    // 随机生成n个数据往栈中填入
    public void pushFromRandom(int n) {
        Random random = new Random();
        for (int i=0; i<n; i++) {
            push(random.nextInt(10));
        }
    }
}
