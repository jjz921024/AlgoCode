import java.util.*;

public class Transform {
    public int[][] transformImage(int[][] mat, int n) {
        int[][] invert_mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                invert_mat[n-j][i] = mat[i][j];
            }
        }
        return invert_mat;
    }
}