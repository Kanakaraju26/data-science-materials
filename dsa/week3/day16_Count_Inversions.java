package week3;

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // Left subarray
        int j = mid + 1;   // Right subarray
        int k = left;      // Merged array
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy temp back to original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}

// 🔍 What is an inversion?
// In an array:

// An inversion is when a larger number comes before a smaller number.

// That means for arr[i] and arr[j], if i < j and arr[i] > arr[j], it's an inversion.

// Example:
// Array = [1, 20, 6, 4, 5]
// Inversions:

// (20,6), (20,4), (20,5), (6,4), (6,5) → Total = 5

// ✅ Idea: Use Merge Sort to Count Inversions
// Why merge sort?
// Because:

// Merge sort divides the array into halves and sorts them.

// While merging two sorted halves, we can efficiently count how many elements from the left side are greater than elements from the right side — which is exactly what inversions are!