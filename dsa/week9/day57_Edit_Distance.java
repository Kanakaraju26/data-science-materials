package week9;

public class day57_Edit_Distance {
    public int editDistance(String s1, String s2) {
        // Code here
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = min operations to convert first i chars of s1 to first j chars of s2
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all i characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all j characters
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No change needed
                } else {
                    int insertCost = dp[i][j - 1] + 1;
                    int deleteCost = dp[i - 1][j] + 1;
                    int replaceCost = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insertCost, Math.min(deleteCost, replaceCost));
                }
            }
        }

        return dp[m][n];
    }
}
