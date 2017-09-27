package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/17.
 */
public class Sohu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int l = scanner.nextInt();
            int[] data = new int[l];
            for (int i=0; i<l; i++){
                data[i] = scanner.nextInt();
            }

            int length = data.length;
            int sum = 0;

            int head = 0;
            int tail = length - 1;
            while (head < tail){
                if (data[head] == data[tail]) {
                    sum += (data[head] * 2);
                    head++;
                    tail--;

                } else if (data[head] < data[tail]) {
                    sum += (data[head] * 2);
                    head++;
                } else if (data[head] > data[tail]) {
                    sum += (data[tail] * 2);
                    tail--;

                }
            }
            if (length % 2 != 0)
                sum += data[head];
            System.out.println(sum);
        }
    }
}
