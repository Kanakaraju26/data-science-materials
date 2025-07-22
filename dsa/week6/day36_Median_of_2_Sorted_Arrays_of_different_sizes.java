package week6;

public class day36_Median_of_2_Sorted_Arrays_of_different_sizes {
    public double medianOf2(int a[], int b[]) {
        // Your Code Here
         if (a.length > b.length) {
            return medianOf2(b, a);
        }

        int m = a.length;
        int n = b.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : a[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : b[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Found correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // Move left in a[]
                high = i - 1;
            } else {
                // Move right in a[]
                low = i + 1;
            }
        }
        return 0;
    }
    
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int total = m + n;
        int midIndex = total / 2;

        int i = 0, j = 0, count = 0;
        int curr = 0, prev = 0;

        while (count <= midIndex) {
            prev = curr;

            if (i < m && (j >= n || a[i] <= b[j])) {
                curr = a[i];
                i++;
            } else {
                curr = b[j];
                j++;
            }

            count++;
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}