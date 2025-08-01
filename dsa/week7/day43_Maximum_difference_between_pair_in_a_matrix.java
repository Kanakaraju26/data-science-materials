package week7;

public class day43_Maximum_difference_between_pair_in_a_matrix {
    public static int findMaxValue(int n, int[][] mat) {
        // code here
        int maxValue = Integer.MIN_VALUE;

        // Create an auxiliary matrix to store maximum elements
        int[][] maxArr = new int[n][n];

        // Start from bottom-right corner
        maxArr[n - 1][n - 1] = mat[n - 1][n - 1];

        // Fill last row
        for (int j = n - 2; j >= 0; j--) {
            maxArr[n - 1][j] = Math.max(mat[n - 1][j], maxArr[n - 1][j + 1]);
        }

        // Fill last column
        for (int i = n - 2; i >= 0; i--) {
            maxArr[i][n - 1] = Math.max(mat[i][n - 1], maxArr[i + 1][n - 1]);
        }

        // Fill rest of the matrix and find maxValue
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int potential = maxArr[i + 1][j + 1] - mat[i][j];
                maxValue = Math.max(maxValue, potential);

                maxArr[i][j] = Math.max(
                    mat[i][j],
                    Math.max(maxArr[i][j + 1], maxArr[i + 1][j])
                );
            }
        }

        return maxValue;
    }
}
