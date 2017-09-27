package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/16.
 */
public class RL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();

            while (s.contains("RL")) {
                int last = s.indexOf("RL") - 1;
                int next = s.indexOf("RL") + 1;
                char[] chars = s.toCharArray();
                if (chars[last] == 'R' || next == s.length())
                    s = s.replaceFirst("RL", "L");
                else {
                    s = s.replaceFirst("RL", "R");
                }
            }
            System.out.println(s.length());
        }
    }
}
