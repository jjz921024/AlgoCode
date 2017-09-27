package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jun on 2017/9/8.
 */
public class Sogou {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            double[] angle = new double[n];
            for (int i=0; i<n; i++){
                angle[i] = Double.parseDouble(bufferedReader.readLine());
            }

            double max = Double.MIN_VALUE;
            for (int i=n-1; i>=0; i--) {
                double cur = angle[i];
                for (int j=i; j>=0; j--) {
                    double val = cur - angle[j];
                    while (val > 360.0) {
                        val = val - 360.0;
                    }
                    if (val > 180.0 && val < 360.0) {
                        val = 360.0 - val;
                    }
                    max = val > max ? val : max;
                }
            }
            System.out.printf("%.8f\n",max);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
