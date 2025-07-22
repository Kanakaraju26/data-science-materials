package week6;

import java.util.Arrays;

public class day41_sorted_matrix {
    int[][] sortedMatrix(int N, int mat[][]) {
        // code here
        int n = mat.length;

        int[] temp = new int[n * n];
        int index = 0;
        for (int[] row : mat) {
            for (int val : row) {
                temp[index++] = val;
            }
        }

        Arrays.sort(temp);

        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[index++];
            }
        }
    
    return mat;
    }
}
