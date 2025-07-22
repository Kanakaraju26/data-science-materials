package week6;

public class day40_Row_with_max_1s {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;

        int maxRowIndex = -1;
        int j = m - 1;  // start from the top-right corner

        for (int i = 0; i < n; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j--; // move left if you see a 1
                maxRowIndex = i; // update the result
            }
        }
        return maxRowIndex;
    }
    public int rowmat(int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;
        
        int colcounter = 0;
        int rowcounter = 0;
        
        int maxrow = 0;
        int temp = 0;
        
        int rowidx = -1;

        for (int i = 0; i < (row * col); i++) {
            if (arr[rowcounter][colcounter] == 1) temp += 1;

            colcounter++;

            if (colcounter == col) {
                if (temp > maxrow) {
                    maxrow = temp;
                    rowidx = rowcounter;
                }
                colcounter = 0;
                rowcounter++;
                temp = 0;
            }
        }

        return rowidx;
    }    
}
