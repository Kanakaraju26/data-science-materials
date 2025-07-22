package week6;

import java.util.Arrays;

public class day39_Median_in_a_row_wise_sorted_Matrix {
    int median(int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;

        // Define the search range for the median
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Get the min and max from the matrix (first and last of rows, since rows are sorted)
        for (int i = 0; i < rows; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][cols - 1]);
        }

        int desired = (rows * cols) / 2;  // Position of median

        // Binary search on the value range
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

            // Count elements less than or equal to mid in each row using binary search
            for (int i = 0; i < rows; i++) {
                count += countSmallerOrEqual(mat[i], mid);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Helper to count number of elements <= target using binary search
    private static int countSmallerOrEqual(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

     public static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] flat = new int[rows * cols];

        // Flatten the matrix
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                flat[index++] = num;
            }
        }

        // Sort the flattened array
        Arrays.sort(flat);

        // Return the middle element
        return flat[flat.length / 2];
    }
}
