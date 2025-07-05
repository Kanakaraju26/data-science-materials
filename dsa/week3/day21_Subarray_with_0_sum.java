package week3;

import java.util.HashSet;

class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[]) {
        // Your code here
        HashSet<Integer> prefixSums = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum == 0 || prefixSums.contains(sum)) {
                return true;
            }

            prefixSums.add(sum);
        }

        return false;
    }
}

// int n = arr.length;
        
//         // Try every possible subarray
//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 sum += arr[j];
//                 if (sum == 0) {
//                     return true;
//                 }
//             }
//         }
        
//         return false;