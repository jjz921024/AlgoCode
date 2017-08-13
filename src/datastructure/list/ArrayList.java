package datastructure.list;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jun on 2017/4/7.
 */
public class ArrayList {

    int length = 0;  //长度比下标多1
    int[] data = null;

    public void initList(){
        System.out.println("Please input a series int with the end of enter");
        this.data = new int[5]; //todo
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("f")){
            this.data[this.length] = scanner.nextInt();
            this.length++;
        }
        System.out.println(Arrays.toString(this.data));
        System.out.println("the length of list: " + this.length);
    }

    public boolean isListEmpty(){
        if (this.length == 0 || this.data == null){
            System.out.println("list is empty");
            return true;
        }
        System.out.println("list is not empty");
        return false;
    }

    public void clearList(){
        this.data = null;
        this.length = 0;
    }

    public int getElem(int i){
        if (i > 0 && i <= this.length){
            int a = this.data[i - 1];
            System.out.println("the element of " + i + "is :" + a);
            return a;
        }
        System.out.println("locate error");
        return -1;
    }

    public int getLength() {
        return length;
    }

    public int locateElem(int a){
        for (int i = 0; i < this.length; i++){
            if (this.data[i] == a){
                System.out.println("the location is " + i);
                return i;
            }
        }
        System.out.println("not found");
        return -1;
    }

    public void listInsert(int i, int a){
        if (i >=0 && i < this.length){
            this.length++;  //可以插入，长度加1
            for (int j = i - 1; j < this.length; j++){
                int temp = this.data[j];
                this.data[j] = a;
                a = temp;
            }
            System.out.println("after insert:" + Arrays.toString(this.data));
        }
        System.out.println("insert fail");
    }
    // 在第i个位置之前插入元素， 1<=i<=length
    public int listInsert_1(int i, int a){
        if (this.length == 5){ //数组已满
            System.out.println("array full");
            return -1;
        }
        if (i < 1 || i > this.length + 1){ //i不在数组范围内
            System.out.println("i beyoung limitation");
            return -1;
        }
        if (i <= this.length){ //插入位置不再表尾
            for (int j = this.length - 1; j >= i-1; j--){
                this.data[j+1] = this.data[j];
            }
        }
        // 插入位置是表尾  i == this.length + 1
        this.data[i-1] = a;
        this.length++;
        System.out.println("after insert:" + Arrays.toString(this.data));
        return 0;
    }

    public int listDelete(int i){
        if (i >=0 && i < this.length){
            for (int j = i-1; j < this.length; j++){
                int temp = this.data[j];
                this.data[j] = this.data[j+1];
                this.data[j+1] = temp;
            }
            this.length--;
            int result = this.data[this.length + 1];
            this.data[this.length + 1] = 0;
            System.out.println("delete element is " + result);
            System.out.println("after delete:"+ Arrays.toString(this.data));
            return result;
        }
        System.out.println("delete error");
        return -1;
    }
    public int listDelete_1(int i){
        if (this.length == 0){
            return -1;
        }
        if (i < 1 || i > this.length){
            return -1;
        }
        int a = this.data[i-1];
        if (i < this.length ){ //删除位置不再表尾
            for (int j = i; j < this.length; j++){
                this.data[j-1] = this.data[j];
            }
        }
        this.length--;
        System.out.println("after delete:" + Arrays.toString(this.data));
        return a;
    }
}
