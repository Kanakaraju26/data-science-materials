package week5;

import java.util.Arrays;

public class day35_Median_of_an_Array {
    public double findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            // Convert to double to avoid integer division
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
}