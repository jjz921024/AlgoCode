package exam;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Jun on 2017/9/16.
 */
public class NetEase2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] strings = new String[n];

            int k=0;
            for (k=0; k<n; k++){
                strings[k] = scanner.next("\\w");
            }
            for (int j=k; j<n; j++) {
                strings[j] = "";
            }

            int count = 0;
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    String tmp = strings[i] + strings[j];
                    if (isHuiWen(tmp))
                        count++;
                    tmp = strings[j] + strings[i];
                    if (isHuiWen(tmp))
                        count++;
                }
            }
            System.out.println(count);
        }
    }


    public static boolean isHuiWen(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
