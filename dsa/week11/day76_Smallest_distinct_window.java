package week11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class day76_Smallest_distinct_window {
     public int findSubString(String s) {
        // code here
        // Step 1: get all unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int required = uniqueChars.size();

        // Step 2: sliding window
        HashMap<Character, Integer> freq = new HashMap<>();
        int start = 0, formed = 0, minLen = Integer.MAX_VALUE;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) == 1) {  // first occurrence in window
                formed++;
            }

            // Shrink window from left if all unique chars are present
            while (formed == required) {
                minLen = Math.min(minLen, end - start + 1);

                char startChar = s.charAt(start);
                freq.put(startChar, freq.get(startChar) - 1);
                if (freq.get(startChar) == 0) {
                    formed--;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

/*
 Core Idea (Slogan Version)

"Keep a count of what you have, expand until you have everything, then shrink to get the minimum."

Let’s break it down:

Mapping = frequency table

map[c] = number of times character c appears in the current window

Why? Because you need to know if the window contains all unique characters at least once.

Formed vs Required

required = number of unique characters in the string

formed = number of unique characters currently in the window with count ≥ 1

Only when formed == required do we have a valid window

Expand and Shrink

Expand end → include more characters until the window is valid (formed == required)

Shrink start → remove unnecessary characters to make the window as small as possible while keeping it valid

Keep track of minLen

Each time the window is valid, check if its length is smaller than the previously recorded minimum

Why mapping is crucial

Without a mapping, you’d have to scan the window every time to see if all unique characters are present → O(n) per window

With a mapping, you can check in O(1) whether adding/removing a character affects whether the window is valid

This is what reduces the algorithm to O(n)

So the "slogan" idea of the mapping is really:

“Count what’s inside, know when you have everything, and adjust the window to keep it minimal.”
 */