package week8;

public class day56_Word_Wrap {
    public int solveWordWrap(int[] arr, int k) {
        // Code here
        int n = arr.length;

    // extras[i][j] = extra spaces if words from i to j are in one line
    int[][] extras = new int[n + 1][n + 1];

    // lc[i][j] = line cost of putting words from i to j in one line
    int[][] lc = new int[n + 1][n + 1];

    // c[j] = optimal cost for words 1 to j
    int[] c = new int[n + 1];

    // p[j] = index where line starts for words up to j
    int[] p = new int[n + 1];

    // Step 1: Calculate extra spaces
    for (int i = 1; i <= n; i++) {
        extras[i][i] = k - arr[i - 1];
        for (int j = i + 1; j <= n; j++) {
            extras[i][j] = extras[i][j - 1] - arr[j - 1] - 1; // subtract word length + space
        }
    }

    // Step 2: Calculate line cost
    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            if (extras[i][j] < 0) {
                lc[i][j] = Integer.MAX_VALUE; // not possible
            } else if (j == n) {
                lc[i][j] = 0; // last line → cost = 0
            } else {
                lc[i][j] = extras[i][j] * extras[i][j]; // square of extra spaces
            }
        }
    }

    // Step 3: DP to find minimum cost
    c[0] = 0;
    for (int j = 1; j <= n; j++) {
        c[j] = Integer.MAX_VALUE;
        for (int i = 1; i <= j; i++) {
            if (c[i - 1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE &&
                c[i - 1] + lc[i][j] < c[j]) {
                c[j] = c[i - 1] + lc[i][j];
                p[j] = i;
            }
        }
    }

    return c[n];
    }
}
