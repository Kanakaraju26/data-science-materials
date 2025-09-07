package week12;

public class day82_Wildcard_string_matching {
    static boolean match(String wild, String pattern) {
        int i = 0; // pointer for wild
        int j = 0; // pointer for pattern
        int starIndex = -1;     // last position of '*' in wild
        int matchIndex = -1;    // position in pattern when '*' was used

        while (j < pattern.length()) {
            // Case 1: characters match or '?' in wild
            if (i < wild.length() &&
                (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?')) {
                i++;
                j++;
            }
            // Case 2: '*' in wild → record star position and move wild pointer
            else if (i < wild.length() && wild.charAt(i) == '*') {
                starIndex = i;
                matchIndex = j;
                i++;
            }
            // Case 3: mismatch, but we saw a '*' before → backtrack
            else if (starIndex != -1) {
                i = starIndex + 1;
                matchIndex++;
                j = matchIndex;
            }
            // Case 4: mismatch with no '*' to backtrack to → fail
            else {
                return false;
            }
        }

        // If there are remaining characters in wild, they must all be '*'
        while (i < wild.length() && wild.charAt(i) == '*') {
            i++;
        }

        return i == wild.length();
    }
}
