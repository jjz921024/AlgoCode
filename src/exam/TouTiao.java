package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jun on 2017/9/10.
 */
public class TouTiao {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] users = new int[n];
            String[] split = bufferedReader.readLine().split(" ");
            for (int i=0; i<split.length; i++) {
                users[i] = Integer.parseInt(split[i]);
            }
            int q = Integer.parseInt(bufferedReader.readLine());
            while (--q >= 0) {
                String[] groups = bufferedReader.readLine().split(" ");
                int l = Integer.parseInt(groups[0]);
                int r = Integer.parseInt(groups[1]);
                int k = Integer.parseInt(groups[2]);
                int count = 0;
                for (int i=l-1; i<r; i++) {
                    if (users[i] == k)
                        count++;
                }
                System.out.println(count);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
