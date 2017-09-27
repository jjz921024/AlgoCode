package exam.mi;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/18.
 */
public class Jie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String n = scanner.next();
            long l = Long.parseLong(n);

            long result = 1;
            for (long i=1; i<=l; i++) {
                result *= i;
            }
            System.out.println(result);
        }
    }
}
