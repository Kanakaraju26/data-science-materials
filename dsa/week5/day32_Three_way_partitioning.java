package week5;

public class day32_Three_way_partitioning {
    public void threeWayPartition(int arr[], int a, int b) {
        // code here
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < a) {
                // Swap arr[low] and arr[mid], then increment both
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] > b) {
                // Swap arr[mid] and arr[high], then decrement high only
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            } else {
                // Element is in the range [a, b], just move mid
                mid++;
            }
        }
    }
}
