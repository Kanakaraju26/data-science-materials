import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) {
            return new int[0][];
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize the result list
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Step 3: Iterate and merge
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                // Overlap: merge intervals
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap: add current interval
                merged.add(current);
            }
        }

        // Convert result list to array
        return merged.toArray(new int[merged.size()][]);
    }
}