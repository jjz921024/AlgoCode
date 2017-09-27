package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/10.
 */
public class TTString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int m = scanner.nextInt();
            char[] chars = s.toCharArray();
            int max = 0;
            // 考察一个字符
            for (int i=chars.length-1; i>=0; i--) {
                char cur = chars[i];
                int count = 0;
                int tmp = m;
                // 向前遍历
                for (int j=i-1; j>=0; j--) {
                    if (chars[j] == cur) {
                        count++;
                    } else {
                        tmp=-(i-j);
                        if (tmp >= 0)
                            count++;
                    }
                }
                max = count > max ? count : max;
            }
            System.out.println(max);
        }
    }
}
