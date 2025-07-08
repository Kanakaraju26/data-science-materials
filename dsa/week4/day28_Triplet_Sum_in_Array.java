package week4;

import java.util.Arrays;

public class day28_Triplet_Sum_in_Array {
    public static boolean hasTripletSum(int arr[], int target) {
        // Your code Here
        Arrays.sort(arr);  

        int n = arr.length;

        // Fix one element and use two pointers for the rest
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    return true;  // Triplet found
                } else if (sum < target) {
                    left++;  // Increase the sum
                } else {
                    right--;  // Decrease the sum
                }
            }
        }

        return false; 
    }
}
