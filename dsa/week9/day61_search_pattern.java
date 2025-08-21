package week9;

import java.util.ArrayList;

public class day61_search_pattern {
    ArrayList<Integer> search(String pat, String txt) {
       ArrayList<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        constructLPS(pat, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched 
                // store the start index in result
                if (j == m) {
                    ans.add(i - j);
                    // Use LPS of previous index to skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }
            // If there is a mismatch
            else {
                // Use lps value of previous index to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return ans;
    }

    void constructLPS(String pat, int[] lps) {
        int i = 0;
        int j = 1;
        lps[0] = 0;

        while (j < pat.length()) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
    }

    ArrayList<Integer> searchi(String pat, String txt) {
        ArrayList<Integer> idx = new ArrayList<>();
        
        int n = txt.length();
        int m = pat.length();
        
        if(m > n) return idx;  // pattern longer than text → no match
        
        for(int i = 0; i <= n - m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if(j == m) { // full match found
                idx.add(i);
            }
        }
        
        return idx;
    }
}
