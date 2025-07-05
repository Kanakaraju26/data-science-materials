package week3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        Set<String> seenPairs = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);

                    String pairKey = first + "," + second;

                    if (!seenPairs.contains(pairKey)) {
                        seenPairs.add(pairKey);

                        ArrayList<Integer> pair = new ArrayList<>();
                        pair.add(first);
                        pair.add(second);
                        result.add(pair);
                    }
                }
            }
        }

        // Sort the final list of pairs
        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        return result;
    }
}

// Optimized way


// import java.util.*;

// class Solution {
//     public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
//         Set<Integer> set = new HashSet<>();
//         Set<String> seenPairs = new HashSet<>();
//         ArrayList<ArrayList<Integer>> result = new ArrayList<>();

//         for (int num : arr) {
//             if (set.contains(-num)) {
//                 int first = Math.min(num, -num);
//                 int second = Math.max(num, -num);
//                 String key = first + "," + second;

//                 if (!seenPairs.contains(key)) {
//                     seenPairs.add(key);
//                     result.add(new ArrayList<>(Arrays.asList(first, second)));
//                 }
//             }
//             set.add(num); // Add current number for future checks
//         }

//         // Sort the result list of pairs
//         result.sort((a, b) -> {
//             if (!a.get(0).equals(b.get(0)))
//                 return a.get(0) - b.get(0);
//             return a.get(1) - b.get(1);
//         });

//         return result;
//     }
// }
