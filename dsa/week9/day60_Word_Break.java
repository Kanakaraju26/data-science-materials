package week9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day60_Word_Break {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary)); 
        int n = s.length();
    
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // base case: empty string
    
        // check prefixes
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further splits
                }
            }
        }
    
        return dp[n];
    }
}
