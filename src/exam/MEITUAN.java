package exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Jun on 2017/9/14.
 */
public class MEITUAN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] num = new String[n];
            for (int i=0; i<n; i++){
                num[i] = scanner.next();
            }

            int count = 0;
            for (int i=0; i<n; i++) {
                String num1 = num[i];
                for (int j=i+1; j<n; j++) {
                    String num2 = num[j];
                    if (Long.parseLong(num1 + num2) % 7 == 0) {
                        count++;
                    }
                    if (Long.parseLong(num2 + num1) % 7 == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
