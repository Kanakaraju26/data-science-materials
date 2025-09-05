package week11;

import java.util.PriorityQueue;

public class day77_Rearrange_characters {
    public static String rearrangeString(String s) {
        // code here
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(new int[] { freq[i], i });
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = new int[] { 0, -1 }; // freq, char index

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) (curr[1] + 'a'));
            curr[0]--; // decrease frequency

            if (prev[0] > 0)
                pq.add(prev); // put previous back

            prev = curr;
        }

        // Check if rearrangement is valid
        if (sb.length() != s.length())
            return "";
        return sb.toString();
    }
}

/*
s = "aaabbc"
Step 0: Prep
Frequency array → a:3, b:2, c:1

Max-heap (pq) stores: [3,a], [2,b], [1,c]

prev = [0,-1] → initially no previous character

Step 1: Start the while loop
Line:




int[] curr = pq.poll();
sb.append((char)(curr[1] + 'a'));
curr[0]--; // decrease frequency
pq.poll() → pick character with highest remaining frequency

Append it to result sb

Decrease its frequency by 1

Example:

First iteration: curr = [3,0] → 'a'

sb = "a"

curr[0]-- → [2,0]

Step 2: Put previous character back



if (prev[0] > 0) pq.add(prev);
prev is the character we used in the last step

At first iteration, prev[0] = 0 → skip

In later iterations, we put back the previous character into the heap if it still has remaining frequency.

Why?

To avoid repeating the same character consecutively.

We temporarily “hold” the previous character until it is safe to use again.

Step 3: Update previous



prev = curr;
After appending current character, we make it prev for the next iteration

Step 4: Iteration by iteration for "aaabbc"
Initial heap: [3,a],[2,b],[1,c]

| Iter | curr polled | sb       | curr freq after decrement | prev   | heap after adding prev back |
| ---- | ----------- | -------- | ------------------------- | ------ | --------------------------- |
| 1    | a (3→2)     | "a"      | \[2,a]                    | \[2,a] | \[2,b],\[1,c]               |
| 2    | b (2→1)     | "ab"     | \[1,b]                    | \[1,b] | \[2,a],\[1,c]               |
| 3    | a (2→1)     | "aba"    | \[1,a]                    | \[1,a] | \[1,b],\[1,c]               |
| 4    | b (1→0)     | "abab"   | \[0,b]                    | \[0,b] | \[1,a],\[1,c]               |
| 5    | a (1→0)     | "ababa"  | \[0,a]                    | \[0,a] | \[1,c]                      |
| 6    | c (1→0)     | "ababac" | \[0,c]                    | \[0,c] | \[]                         |


The prev logic ensures no character is repeated consecutively, because a character is only pushed back after the next different character is used.

Step 5: Check if valid



if (sb.length() != s.length()) return "";
If the resulting string is shorter than original → impossible to rearrange

In this case, sb.length() = 6 = s.length() → valid

*/