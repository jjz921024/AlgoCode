package exam.mi;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/18.
 */
public class PiPei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] text = scanner.next().toCharArray();
            char[] pattern = scanner.next().toCharArray();

            int head = 0;
            int tail = 0;
            int min = 0;
            int res1 = -1;
            int res2 = -1;
            for (int i=0; i<text.length; i++) {
                char cur = text[i];

                for (int j=0; j<pattern.length; j++) {
                    if (cur == text[j]) {
                        if (j == 0) {
                            head = j;
                        } else if (j == pattern.length-1) {
                            tail = j;
                            if (min < (tail-head+1)) {
                                min = (tail-head+1);
                                res1 = head;
                                res2 = tail;
                                head = 0;
                                tail = 0;

                            }
                        }
                    }
                }

            }
            System.out.println(res1 + " " + res2);

        }
    }
}

/*
if (min == 0) {
        min = (tail-head+1);
        } else*/
