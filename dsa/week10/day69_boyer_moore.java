package week10;

import java.util.Arrays;

public class day69_boyer_moore {
    private final int[] badCharTable;   // For bad character rule
    private final int[] goodSuffixTable; // For good suffix rule
    private final char[] pattern;

    public day69_boyer_moore(String pat) {
        this.pattern = pat.toCharArray();
        this.badCharTable = buildBadCharTable();
        this.goodSuffixTable = buildGoodSuffixTable();
    }

    // Build bad character table
    private int[] buildBadCharTable() {
        int ALPHABET_SIZE = 256; // assume extended ASCII
        int[] table = new int[ALPHABET_SIZE];
        Arrays.fill(table, -1);

        // Store the last index of each character in pattern
        for (int i = 0; i < pattern.length; i++) {
            table[pattern[i]] = i;
        }
        return table;
    }

    // Build good suffix table
    private int[] buildGoodSuffixTable() {
        int m = pattern.length;
        int[] table = new int[m];
        int[] borderPos = new int[m + 1];

        int i = m, j = m + 1;
        borderPos[i] = j;

        // Step 1: preprocess for borders
        while (i > 0) {
            while (j <= m && pattern[i - 1] != pattern[j - 1]) {
                if (table[j] == 0) {
                    table[j] = j - i;
                }
                j = borderPos[j];
            }
            i--; j--;
            borderPos[i] = j;
        }

        // Step 2: fill the table
        j = borderPos[0];
        for (i = 0; i <= m; i++) {
            if (table[i] == 0) {
                table[i] = j;
            }
            if (i == j) {
                j = borderPos[j];
            }
        }
        return table;
    }

    // Search method
    public void search(String text) {
        char[] txt = text.toCharArray();
        int n = txt.length;
        int m = pattern.length;

        int s = 0; // shift of the pattern
        while (s <= (n - m)) {
            int j = m - 1;

            // Compare from right to left
            while (j >= 0 && pattern[j] == txt[s + j]) {
                j--;
            }

            if (j < 0) {
                System.out.println("Pattern found at index " + s);
                s += goodSuffixTable[0]; // shift using good suffix
            } else {
                int badCharShift = j - badCharTable[txt[s + j]];
                int goodSuffixShift = goodSuffixTable[j + 1];
                s += Math.max(badCharShift, goodSuffixShift);
            }
        }
    }

    // Main driver
    public static void main(String[] args) {
        String text = "XVZAXY";
        String pattern = "TXY";

        day69_boyer_moore bm = new day69_boyer_moore(pattern);
        bm.search(text);
    }
}

// | Step | Alignment (text substring)                     | Compare (pattern vs text) | Mismatch at           | Rule applied                                  | Shift     | Next alignment        |
// | ---- | ---------------------------------------------- | ------------------------- | --------------------- | --------------------------------------------- | --------- | --------------------- |
// | 1    | Text\[0..2] = `"ABA"`                          | `"ABC"` vs `"ABA"`        | `C` vs `A` (text\[2]) | Bad Character (`A`) → lastOccurrence(`A`) = 0 | shift = 2 | Pattern → Text\[2..4] |
// | 2    | Text\[2..4] = `"AAA"`                          | `"ABC"` vs `"AAA"`        | `C` vs `A` (text\[4]) | Bad Character (`A`) → lastOccurrence(`A`) = 0 | shift = 2 | Pattern → Text\[4..6] |
// | 3    | Text\[4..6] = `"ABC"`                          | `"ABC"` vs `"ABC"`        | ✅ Full match          | —                                             | —         | Found at index **4**  |
// | 4    | (if continue search) Text\[6..8] out of bounds | Stop                      | —                     | —                                             | —         |                       |


// Text = XVZAXY
// Pattern = TXY (length 3)
// Indexes:
// Text → X(0) V(1) Z(2) A(3) X(4) Y(5)
// Pattern → T(0) X(1) Y(2)
// Step 1: First alignment (text[0..2] = "XVZ")
// Text:    X  V  Z  A  X  Y
// Pattern: T  X  Y
// 🔎 Compare right-to-left:
// Pattern[2] = Y vs Text[2] = Z → ❌ mismatch immediately.
// 👉 Bad character = Z
// Last occurrence of Z in "TXY" = none (−1).
// Mismatch index = 2 (pattern Y).
// Shift = max(1, mismatchIndex − lastOccurrence)
// = max(1, 2 − (−1)) = max(1, 3) = 3.
// So we shift pattern 3 steps to the right.
// Step 2: New alignment (pattern at text[3..5] = "AXY")
// Text:    X  V  Z  A  X  Y
// Pattern:          T  X  Y
// 🔎 Compare right-to-left:
// Y vs Y → ✅ match
// X vs X → ✅ match
// T vs A → ❌ mismatch
// Step 3: Apply Good Suffix Rule
// Matched suffix = "XY".
// Does "XY" appear earlier inside "TXY"? ❌ No.
// Any proper suffix of "XY" that is also a prefix of "TXY"? ("Y" → no).
// So good suffix shift = 3 (full pattern length).
// 👉 Compare with Bad Character Rule at mismatch (A vs T):
// Bad char = A, not in pattern.
// Mismatch index = 0.
// Shift = max(1, 0 − (−1)) = 1.
// ✅ Final shift = max(3, 1) = 3.
// So we jump 3 steps → pattern goes past the text → search ends.