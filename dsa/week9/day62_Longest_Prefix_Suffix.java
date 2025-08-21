package week9;

public class day62_Longest_Prefix_Suffix {
    int getLPSLength(String s) {
        // code here
        int n = s.length();
        int[] lps = new int[n]; // longest prefix-suffix array
        int j = 0; // length of previous longest prefix-suffix

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1]; // fallback to smaller border
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
            }
        }
        return lps[n - 1];
    }
}
