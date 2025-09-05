package week11;

public class day74_longest_common_subsequence {
    static int lcs(String s1, String s2) {
        // code here
         int m = s1.length();
        int n = s2.length();

        // Create a 2D DP array
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Match found
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the best without one char
                }
            }
        }

        // The length of LCS is in dp[m][n]
        return dp[m][n];
    }
}

// We have:

// s1 = X Y Z W   (length m = 4)
// s2 = X Y W Z   (length n = 4)


// We create a DP table dp[5][5] (adding 0-th row and column for base cases). Initially, all zeros:

// dp:
//    0 0 0 0 0
// 0  0 0 0 0 0
// 1  0 0 0 0 0
// 2  0 0 0 0 0
// 3  0 0 0 0 0
// 4  0 0 0 0 0

// Step-by-step filling:
// i = 1 (s1[0] = X)

// j = 1 (s2[0] = X) → match → dp[1][1] = 1 + dp[0][0] = 1

// j = 2 (s2[1] = Y) → no match → dp[1][2] = max(dp[0][2], dp[1][1]) = 1

// j = 3 (s2[2] = W) → no match → dp[1][3] = max(dp[0][3], dp[1][2]) = 1

// j = 4 (s2[3] = Z) → no match → dp[1][4] = max(dp[0][4], dp[1][3]) = 1

// dp after i=1:
//    0 0 0 0 0
// 0  0 0 0 0 0
// 1  0 1 1 1 1
// 2  0 0 0 0 0
// 3  0 0 0 0 0
// 4  0 0 0 0 0

// i = 2 (s1[1] = Y)

// j = 1 (s2[0] = X) → no match → dp[2][1] = max(dp[1][1], dp[2][0]) = 1

// j = 2 (s2[1] = Y) → match → dp[2][2] = 1 + dp[1][1] = 2

// j = 3 (s2[2] = W) → no match → dp[2][3] = max(dp[1][3], dp[2][2]) = 2

// j = 4 (s2[3] = Z) → no match → dp[2][4] = max(dp[1][4], dp[2][3]) = 2

// dp after i=2:
//    0 0 0 0 0
// 0  0 0 0 0 0
// 1  0 1 1 1 1
// 2  0 1 2 2 2
// 3  0 0 0 0 0
// 4  0 0 0 0 0

// i = 3 (s1[2] = Z)

// j = 1 (s2[0] = X) → no match → dp[3][1] = max(dp[2][1], dp[3][0]) = 1

// j = 2 (s2[1] = Y) → no match → dp[3][2] = max(dp[2][2], dp[3][1]) = 2

// j = 3 (s2[2] = W) → no match → dp[3][3] = max(dp[2][3], dp[3][2]) = 2

// j = 4 (s2[3] = Z) → match → dp[3][4] = 1 + dp[2][3] = 3

// dp after i=3:
//    0 0 0 0 0
// 0  0 0 0 0 0
// 1  0 1 1 1 1
// 2  0 1 2 2 2
// 3  0 1 2 2 3
// 4  0 0 0 0 0

// i = 4 (s1[3] = W)

// j = 1 (s2[0] = X) → no match → dp[4][1] = max(dp[3][1], dp[4][0]) = 1

// j = 2 (s2[1] = Y) → no match → dp[4][2] = max(dp[3][2], dp[4][1]) = 2

// j = 3 (s2[2] = W) → match → dp[4][3] = 1 + dp[3][2] = 3

// j = 4 (s2[3] = Z) → no match → dp[4][4] = max(dp[3][4], dp[4][3]) = 3

// Final DP table:
//    0 0 0 0 0
// 0  0 0 0 0 0
// 1  0 1 1 1 1
// 2  0 1 2 2 2
// 3  0 1 2 2 3
// 4  0 1 2 3 3


// ✅ Length of LCS: dp[4][4] = 3

// One possible LCS: "XYZ" or "XYW" depending on how you reconstruct it.