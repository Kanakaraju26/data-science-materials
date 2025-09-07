package week12;

public class day78_Min_Chars_to_Add_for_Palindrome {
    public int minChar(String s) {
        // code here
         String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "$" + rev;
        int lps[] = computeLPS(combined);
        return s.length() - lps[lps.length - 1];
    }

    // KMP preprocessing to compute Longest Prefix Suffix (LPS) array
    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;
        while (i < n) {
            // System.out.println(str.charAt(i) + " " + str.charAt(len) + " " + len);
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // try previous prefix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

// Index:   0 1 2 3 4 5 6
// Chars:   A B C $ C B A

// Index:   0 1 2 3 4 5 6
// Chars:   A B C $ C B A
// LPS:     0 0 0 0 0 0 1
