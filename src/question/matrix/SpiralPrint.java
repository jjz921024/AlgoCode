package question.matrix;

import com.sun.org.apache.bcel.internal.generic.DCMPG;

/**
 * Created by Jun on 2017/9/12.
 * 转圈打印矩阵
 */
public class SpiralPrint {
    public static void spiralPrintMatrix(int[][] matrix) {
        int hR = 0; //左上角 Row 行
        int hC = 0; //左上角 Column 列
        int tR = matrix.length - 1;
        int tC = matrix[0].length - 1;
        while (hR <= tR && hC <= tC) {
            printEdge(matrix, hR++, hC++, tR--, tC--);
        }
    }

    private static void printEdge(int[][] matrix, int hr, int hc, int tr, int tc) {
        if (hr == tr) {  // 只有一行
            for (int i=hc; i<=tc; i++) {
                System.out.print(matrix[hr][i] + " ");
            }
        } else if (hc == tc) { //只有一列
            for (int i=hr; i<=tr; i++) {
                System.out.print(matrix[i][hc] + " ");
            }
        } else { //一般情况
            int curR = hr;
            int curC = hc;
            while (curC != tc) {
                System.out.print(matrix[hr][curC]+ " ");
                curC++;
            }
            while (curR != tr) {
                System.out.print(matrix[curR][tc]+ " ");
                curR++;
            }
            while (curC != hc) {
                System.out.print(matrix[tr][curC]+ " ");
                curC--;
            }
            while (curR != hr) {
                System.out.print(matrix[curR][hc]+ " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                        {1,2,3},
                        {5,6,7},
                        {9,10,11}};
        spiralPrintMatrix(data);
    }
}
