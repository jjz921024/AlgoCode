package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/10.
 */
public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int power1 = scanner.nextInt();
            int locate1 = scanner.nextInt();
            int dir1 = scanner.nextInt();
            int power2 = scanner.nextInt();
            int locate2 = scanner.nextInt();
            int dir2 = scanner.nextInt();

            int count = 0;
            // 相反
            if (dir1 == -1 && dir2 == 1) {
                if (power1 > locate1)
                    count++;
                if (power2 > len - locate2 - 1)
                    count++;
                System.out.println(count);


            } else if (dir1 == dir2 && dir1 == -1) {
                //同向左
                // 第一辆车能出去的情况
                if (power1 > locate1) {
                    count++;
                    if (power2 > locate2)
                        count++;
                } else {
                    //第一辆车出不去的情况
                    locate1 = locate1 - power1;
                    if (power2 > locate2 - locate1 - 1) {
                        power2 = power2 - locate2 - locate1 - 1;
                        //locate2 = locate1 + 1;
                        if (power2 > 2 * locate1)
                            count++;
                        if (power2 > 2 * locate1 + 2)
                            count++;
                    }
                }
                System.out.println(count);


            } else if (dir1 == dir2 && dir1 == 1) {
                //同向右
                if (power2 > len - locate2 - 1) {
                    count++;
                    if (power1 > len - locate1 - 1)
                        count++;
                } else {
                    //第一辆车出不去的情况
                    locate2 = locate2 + power2;
                    if (power1 > locate2 - locate1 - 1) {
                        power1 = power1 - locate2 - locate1 - 1;

                        if (power1 > 2 * (len - locate2))
                            count++;
                        if (power1 > 2 * (len - locate2) + 2)
                            count++;
                    }
                }
                System.out.println(count);
            } else {
                System.out.println(1);

            }

        }
    }
}
