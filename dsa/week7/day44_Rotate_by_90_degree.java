package week7;

public class day44_Rotate_by_90_degree {
    static void rotate(int mat[][]) {
        // Code Here
         int N = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // Swap mat[i][j] with mat[j][i]
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                // Swap mat[i][j] with mat[i][N - j - 1]
                int temp = mat[i][j];
                mat[i][j] = mat[i][N - j - 1];
                mat[i][N - j - 1] = temp;
            }
        }
    
    }
}
