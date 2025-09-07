package week12;

public class day84_Transform_string {
    int transform(String A, String B) {
        int n = A.length();

        // If lengths differ, impossible
        if (n != B.length()) return -1;

        // If character counts differ, impossible
        int[] freq = new int[256];
        for (char c : A.toCharArray()) freq[c]++;
        for (char c : B.toCharArray()) freq[c]--;
        for (int f : freq) if (f != 0) return -1;

        // Two-pointer scan for longest suffix match
        int i = n - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                j--;
            }
            i--;
        }

        // length of matched suffix
        int matched = n - j - 1;
        return n - matched;
    }
}