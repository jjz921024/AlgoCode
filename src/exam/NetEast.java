package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jun on 2017/8/12.
 */
public class NetEast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
            reverse(data);
        }

        for (int i = 0; i < data.size()-1; i++) {
            System.out.print(data.get(i) + " ");
        }
        System.out.println(data.get(data.size() -1));
    }

    public static void reverse(ArrayList<Integer> a) {
        for (int i=0; i<a.size()/2; i++) {
            int tmp = a.get(i);
            a.set(i, a.size()-i-1);
            a.set(a.size()-i-1, tmp);
        }
    }
    /*public static void reverse(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        for (int i : a) {
            stack.push(i);
        }
        a.clear();
        while (!stack.isEmpty()) {
            a.add(stack.pop());
        }
    }*/
}