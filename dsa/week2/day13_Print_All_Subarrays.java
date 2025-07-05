package week2;

public class day13_Print_All_Subarrays {

    public static void printAllSubarrays(int[] arr) {
        int n = arr.length;

        // Outer loop picks starting index
        for (int i = 0; i < n; i++) {
            // Inner loop picks ending index
            for (int j = i; j < n; j++) {
                // Print subarray from i to j
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println(); // Move to next line after printing a subarray
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("All Subarrays:");
        printAllSubarrays(arr);
    }
}
