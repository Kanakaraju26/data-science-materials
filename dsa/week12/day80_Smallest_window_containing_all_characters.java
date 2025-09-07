package week12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day80_Smallest_window_containing_all_characters {
     public static String smallestWindow(String s, String t) {
        // code here
         if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int required = tFreq.size();   // how many unique chars need to be satisfied
        int formed = 0;                // how many unique chars are currently satisfied
        Map<Character, Integer> windowCounts = new HashMap<>();

        // Result variables: (window length, left, right)
        int[] ans = {-1, 0, 0};

        int left = 0, right = 0;

        while (right < s.length()) {
            // Add char from right into the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If char's count matches t's requirement → formed++
            if (tFreq.containsKey(c) && windowCounts.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink window while it's valid
            while (left <= right && formed == required) {
                // Update answer if smaller window found
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove char from left
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) &&
                    windowCounts.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--; // requirement no longer satisfied
                }

                left++;
            }

            // Expand window
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    public static String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return "";
        }

        // Frequency map for p
        Map<Character, Integer> pFreq = new HashMap<>();
        for (char c : p.toCharArray()) {
            pFreq.put(c, pFreq.getOrDefault(c, 0) + 1);
        }

        // Map to store (startIndex -> length)
        List<int[]> candidates = new ArrayList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> windowFreq = new HashMap<>();

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

                // Check if this window satisfies all requirements
                if (containsAll(windowFreq, pFreq)) {
                    candidates.add(new int[]{i, j - i + 1});
                    break; // no need to expand further from i
                }
            }
        }

        if (candidates.isEmpty()) return "";

        // Sort by length first, then by start index
        candidates.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int start = candidates.get(0)[0];
        int len = candidates.get(0)[1];
        return s.substring(start, start + len);
    }

    // Helper: check if window covers p
    private static boolean containsAll(Map<Character, Integer> window, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            char c = entry.getKey();
            int required = entry.getValue();
            if (window.getOrDefault(c, 0) < required) {
                return false;
            }
        }
        return true;
    }

// This is exactly your described method:
// Loop through all substrings,
// Check if they contain all characters of p,
// Store (start, length) in a list,
// Sort and return the smallest.

// Brute Force Approach (your idea refined)
// Build a frequency map for string p (to know what characters and how many times are required).
// Example: if p = "AABC", then freq = {A:2, B:1, C:1}.
// Iterate through all substrings of s:
// For every starting index i, expand the substring s[i..j].
// Maintain a frequency count of the substring.
// Each time you expand, check if the substring satisfies the requirement (all characters of p are present in required frequencies).
// If yes, store (i, j-i+1) (start index and length) in your map.
// After checking all substrings, sort your (start, length) pairs by:
// Primary key: length (shortest first)
// Secondary key: start index (smallest first)
// Pick the first pair from the sorted result.
// Extract s[start : start+length] as the answer.
}

// Input: s (string), p (string)

// 1. Build pFreq = frequency map of p (does not change)

// 2. Create windowFreq = empty map
// 3. left = 0, right = 0
// 4. bestStart = -1, bestLen = +∞

// 5. While right < s.length():
//        char c = s[right]

//        // update only if c is relevant
//        if c in pFreq:
//             windowFreq[c] = windowFreq.get(c, 0) + 1

//        // Try to shrink if window is valid
//        while validate(windowFreq, pFreq):   // check if window covers p
//             if (right - left + 1) < bestLen:
//                 bestLen = right - left + 1
//                 bestStart = left

//             // shrink from left
//             char leftChar = s[left]
//             if leftChar in pFreq:
//                  windowFreq[leftChar] -= 1
//             left++

//        // expand window
//        right++

// 6. If bestStart == -1: return ""
//    Else return s.substring(bestStart, bestStart + bestLen)


// Function validate(windowFreq, pFreq):
//     For each char c in pFreq:
//          if windowFreq.get(c, 0) < pFreq[c]:
//               return false
//     return true
