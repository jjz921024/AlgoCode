package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/10.
 */
public class DJI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int H = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int h = scanner.nextInt();
            int s = scanner.nextInt();

            float result = 0.0f;
            float s1 = (float)h / (float)x;
            if (s1 >= s) {
                result = s * x;
            } else {
                float h_res = (s - s1) * (x - y);
                if (h_res <= 0.0f)
                    h_res = 0.0f;
                if (h_res + h >= H)
                    h_res = H - h;
                result = h_res + h;
            }

            System.out.println(Math.round(result));
        }
    }
}
