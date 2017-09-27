package question.matrix;

/**
 * Created by Jun on 2017/9/12.
 * 在行列分别排好序的数组中，判断是否包含一个数
 * 0(M+N)复杂度
 */
public class SortMatContain {

    public static boolean isContain(int[][] mat, int k) {
        //从右上角找起
        int row = 0;
        int col = mat[0].length-1;
        while (row<mat.length && col>-1) {
            int cur = mat[row][col];
            if (cur == k)
                return true;
            else if (cur > k) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isContain(new int[][]{{1, 2, 3}, {4, 5, 6}}, 7));
    }
}
