package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/8/28.
 */
public class Sohu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[m];
            for (int i=0; i<m; i++) {
                a[i] = in.nextInt();
            }

            int k = 0;
            int j = 0;
            int count = 0;
            int[] record = new int[100];
            int r = 0;
            int total = 0;
            while (total != n) {
                int val = a[k % m];
                int time = a[j % m];

                for (int i=0; i<time; i++) {
                    System.out.println(val);
                    record[r++] = val;
                    total++;
                }

                k++;
                count++;
                if (count == record[j]) {
                    j++;
                    count = 0;
                }
            }


        }
    }
}
