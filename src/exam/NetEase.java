package exam;

import java.util.Scanner;

/**
 * Created by Jun on 2017/9/16.
 */
public class NetEase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                int[][] mat = new int[m][n];
                for (int i=0; i<m; i++) {
                    //String[] split = scanner.nextLine().split(" ");
                    for (int j=0; j<n; j++) {
                        mat[i][j] = scanner.nextInt();
                    }
                }
                int k = scanner.nextInt();

                boolean flag = false;
                int row = 0;
                int col = mat[0].length-1;
                while (row<mat.length && col>-1) {
                    int cur = mat[row][col];
                    if (cur == k) {
                        System.out.println(1);
                        flag = true;
                        break;
                    } else if (cur > k) {
                        col--;
                    } else {
                        row++;
                    }
                }
                if (!flag)
                    System.out.println(0);
        }
    }
}
