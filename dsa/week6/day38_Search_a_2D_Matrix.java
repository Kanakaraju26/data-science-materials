package week6;

public class day38_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int collen = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][collen-1] >= target){
                for(int j=0;j<collen;j++){
                    if(matrix[i][j]==target) return true;
                }
            }
        }
        return false;
    }
    public boolean search(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = matrix[mid / cols][mid % cols];

        if (midVal == target) {
            return true;
        } else if (midVal < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return false;
}
}
