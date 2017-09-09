package question.exam;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by Jun on 2017/9/8.
 */
public class JD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int count=1;
            int factor=0;

            BitSet bitSet = new BitSet(n*n);
            for (int a=n; a>=1; a--){
                for (int b=n; b>=1; b--) {
                    int left = (int) Math.pow(a,b);

                    if (bitSet.get(left)) factor++;
                    bitSet.set(left);

                }
            }

            for (int c=n; c>=1; c--) {
                for (int d=n; d>=1; d--) {
                    int right = (int) Math.pow(c,d);
                    if (bitSet.get(right)) {
                        count = count * factor;
                    }
                }
            }
            System.out.println(count%1000000007);
        }
    }
}









/*String s = scanner.next();
long n = Long.parseLong(s);
double idx = Math.sqrt(2 * n + 0.25) - 0.5;
System.out.println((int) Math.ceil(idx));*/
