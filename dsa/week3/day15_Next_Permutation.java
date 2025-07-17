package week3;

public class day15_Next_Permutation {
    public void nextPermutation(int[] nums) {
         int i = nums.length - 2;

        // Step 1: Find the first number from the end that is smaller than the one after it
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If we found such a number
        if (i >= 0) {
            int j = nums.length - 1;
            // Find the number just bigger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap them
            swap(nums, i, j);
        }

        // Step 3: Reverse the part after index i
        reverse(nums, i + 1, nums.length - 1);
    }

    // Helper function to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
// 🧠 Simple Explanation of the Steps:
// Step 1: Find the "breaking point"
// Go from right to left and find the first number that is smaller than its next number.

// This is the place where the current order can be made slightly bigger.

// If no such number is found, it means the array is in descending order — like [3,2,1].

// Step 2: Find the next bigger number
// From the right side, look for the smallest number that is just bigger than the number you found in Step 1.

// Then swap them.

// Step 3: Reverse the right side
// To get the next permutation (just slightly bigger), we need to make the right side as small as possible.

// That means reversing the part after the index we swapped.