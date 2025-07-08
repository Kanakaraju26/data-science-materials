package week4;

import java.util.TreeSet;

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
         if (arr == null || arr.length == 0) return 0;

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num); 
        }

        int max = 1;
        int prev = set.first();
        int currLen = 1;

        for (int num : set) {
            if (num == prev + 1) {
                currLen++;
            } else {
                max = Math.max(max, currLen);
                currLen = 1;
            }
            prev = num;
        }

        return Math.max(max, currLen);
    }
}