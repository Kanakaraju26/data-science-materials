package week2;

public class day12_Merge_Without_Extra_Space {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length, m = b.length;
        int gap = nextGap(n + m);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < (n + m)) {
                // Determine element positions
                int a_i = (i < n) ? a[i] : b[i - n];
                int a_j = (j < n) ? a[j] : b[j - n];

                // Swap if needed
                if (a_i > a_j) {
                    if (i < n && j < n) {
                        // both in a[]
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    } else if (i < n && j >= n) {
                        // a[i] and b[j - n]
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    } else {
                        // both in b[]
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
}
