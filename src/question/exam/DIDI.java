package question.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jun on 2017/8/26.
 */
public class DIDI {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        scanner.close();

        printmax(list);


    }
    private static void printmax(List<Integer> list) {
        if (allless0(list)) {
            System.out.println(Collections.max(list));
            return;
        }
        int max = 0;
        int maxtemp = 0;
        for (Integer integer : list) {
            maxtemp += integer;
            if (maxtemp > max) {
                max = maxtemp;
            } else if (maxtemp < 0) {
                maxtemp = 0;
            }
        }
        System.out.println(max);
    }

    private static boolean allless0(List<Integer> list) {
        for (Integer integer : list) {
            if (integer >= 0) {
                return false;
            }
        }
        return true;
    }
}
