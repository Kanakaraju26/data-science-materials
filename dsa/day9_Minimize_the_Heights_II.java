import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[n - 1];

        int ans = max - min;

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue; // skip if it becomes negative

            int curr_min = Math.min(arr[0] + k, arr[i] - k);
            int curr_max = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, curr_max - curr_min);
        }

        return ans;
    }
}
