package week4;

class Solution {
    int maxProduct(int[] arr) {
        // code here
       if (arr == null || arr.length == 0) return 0;

        int currMax = arr[0];
        int currMin = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = currMax;
            
            currMax = Math.max(arr[i], Math.max(currMax * arr[i], currMin * arr[i]));
            currMin = Math.min(arr[i], Math.min(temp * arr[i], currMin * arr[i]));
            
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        
        return maxSoFar;
    }
}