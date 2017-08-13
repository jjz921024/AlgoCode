package datastructure.tree;

import java.util.Scanner;

/**
 * Created by Jun on 2017/6/20.
 */
public class start {
    static String start = "* * ";
    public static void main(String[] args) {


        printStart(4);

        /*for (int i = 0; i < 4; i++){
            System.out.print("* ");
            for (int j = 0; j < i; j++){
                System.out.print(start);
            }
            System.out.println();
        }*/
    }

    public static void printStart(int lines){

        System.out.println("* ");
        StringBuffer sb = new StringBuffer("* ");
        for (int i = 0; i < lines; i++){
            StringBuffer newsb = sb.append(start);
            System.out.println(newsb);

        }
    }
}
