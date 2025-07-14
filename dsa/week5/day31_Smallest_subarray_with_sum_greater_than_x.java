package week5;

public class day31_Smallest_subarray_with_sum_greater_than_x {
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > x) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static int smallestSubarray(int x, int[] arr) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0, currentSum = 0;

        while (end < n) {
            // Add elements to currentSum until it exceeds x
            while (end < n && currentSum <= x) {
                currentSum += arr[end++];
            }

            // Shrink the window from the left as long as currentSum > x
            while (currentSum > x && start < n) {
                minLength = Math.min(minLength, end - start);
                currentSum -= arr[start++];
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
