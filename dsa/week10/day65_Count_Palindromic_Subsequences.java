package week10;

public class day65_Count_Palindromic_Subsequences {
    int countPS(String s) {
        // Your code here
        if(s.length()==1) return 1;
        int n = s.length();
        int[][] dp = new int[n][n];

        // Fill dp for substrings of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider all substrings of length >= 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }
}
