package week11;

import java.util.ArrayList;

public class day75_generate_Ip {
    public ArrayList<String> generateIp(String s) {
        // code here
         ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int index, ArrayList<String> current, ArrayList<String> result) {
        // Base case: 4 parts
        if (current.size() == 4) {
            if (index == s.length()) { // used all digits
                result.add(String.join(".", current));
            }
            return;
        }

        // Try parts of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            // Skip if part has leading zero
            if (part.length() > 1 && part.startsWith("0")) continue;

            int value = Integer.parseInt(part);
            if (value > 255) continue;

            current.add(part); // choose
            backtrack(s, index + len, current, result); // explore
            current.remove(current.size() - 1); // backtrack
        }
    }
}

/* 
Step 1: Start recursion

currentIP = [], index = 0, parts = 0.

We try length = 1, 2, 3 for the first part.

First part options:

len = 1 → "2" ✅ valid

currentIP = ["2"], index = 1 → recurse

len = 2 → "25" ✅ valid

currentIP = ["25"], index = 2 → recurse

len = 3 → "255" ✅ valid

currentIP = ["255"], index = 3 → recurse

Second part (depends on first part)
Case 1: first part = "2", index = 1

Remaining string = "55678166"

Try length 1–3:

"5" ✅ valid → ["2","5"] → recurse

"55" ✅ valid → ["2","55"] → recurse

"556" ❌ invalid (>255) → skip

Case 2: first part = "25", index = 2

Remaining = "5678166"

"5" ✅ → ["25","5"]

"56" ✅ → ["25","56"]

"567" ❌ → skip

Case 3: first part = "255", index = 3

Remaining = "678166"

"6" ✅ → ["255","6"]

"67" ✅ → ["255","67"]

"678" ❌ → skip

Third part
Example: first = "255", second = "6"

Remaining = "78166"

"7" ✅ → ["255","6","7"] → recurse for fourth part

"78" ✅ → ["255","6","78"]

"781" ❌ → skip

Fourth part

Fourth part uses the remaining string

Check validity (0–255, no leading zeros)

For example:

["255","6","7","8166"] ❌ invalid (>255) → discard

["255","6","78","166"] ✅ valid → add "255.6.78.166" to result

Other valid combinations

["255","67","8","166"] → "255.67.8.166" ✅ valid

["255","67","81","66"] → "255.67.81.66" ✅ valid

["255","67","816","6"] ❌ invalid (>255) → discard

["255","6","7","8166"] ❌ invalid → discard

Step 2: Key observation

Backtracking explores all combinations of 1–3 digit splits for each part.

At each step, we prune invalid numbers early: >255 or leading zeros.

Only when 4 parts are chosen AND string is fully used → add to result.

Step 3: Possible valid IPs for "255678166"

After carefully checking splits:

"255.6.78.166" ✅

"255.67.8.166" ✅

"255.67.81.66" ✅

No other valid splits exist because other partitions exceed 255 or would leave too many/few digits.
*/