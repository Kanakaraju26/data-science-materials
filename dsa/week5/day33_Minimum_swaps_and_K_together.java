package week5;

public class day33_Minimum_swaps_and_K_together {
    int minSwap(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Count how many elements are <= k
        int count = 0;
        for (int value : arr) {
            if (value <= k) {
                count++;
            }
        }

        // Step 2: Count bad elements in the first window of size count
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        // Step 3: Slide the window and update the minimum bad count
        int minSwaps = bad;
        for (int i = 0, j = count; j < n; i++, j++) {
            if (arr[i] > k) {
                bad--;
            }
            if (arr[j] > k) {
                bad++;
            }
            minSwaps = Math.min(minSwaps, bad);
        }

        return minSwaps;
    }

    int minSwaps(int[] arr, int k) {
        // Complete the function
        int i = 0, n = arr.length - 1;
        int cnt = 0;
        while (i < n) {
            // System.out.println(arr[i] + " " + arr[n]);
            if (arr[i] <= k) {
                i++;
            } else if (arr[n] <= k && arr[i] > k) {
                int temp = arr[n];
                arr[n] = arr[i];
                arr[i] = temp;
                n--;
                i++;
                cnt++;
            } else if (arr[n] > k && arr[i] > k) {
                n--;
            } else {
                i++;
            }
        }
        return cnt;
    }
}
