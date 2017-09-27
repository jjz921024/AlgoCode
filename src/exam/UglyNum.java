package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/10.
 */
public class UglyNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            System.out.println(getUglyNum(scanner.nextInt()));
        }
    }

    public static boolean isUgly(int num) {
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1;
    }

    public static int getUglyNum(int index) {
        if (index <= 0)
            return 0;
        int number = 0;
        int uglyFound = 0;
        while(uglyFound < index)
        {
            ++number;
            if(isUgly(number))
                ++uglyFound;
        }
        return number;
    }
}