package exam.ctrip;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Jun on 2017/9/21.
 */
public class Sushu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();

            CopyOnWriteArraySet<Integer> sushu = new CopyOnWriteArraySet<>();
            boolean flag = true;
            for (int i=2; i<=n; i++) {
                flag = true;
                for (int j=2; j<i; j++) {
                    if (i%j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    sushu.add(i);
            }

            int count = 0;
            for (int i : sushu) {
                int other = n - i;
                if (sushu.contains(other)) {
                    count++;
                    sushu.remove(other);
                    sushu.remove(i);
                }
            }
            System.out.println(count);
        }
    }
}
