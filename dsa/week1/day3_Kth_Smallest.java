package week1;

import java.util.PriorityQueue;

public class day3_Kth_Smallest {
    public static int kthSmallest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) 
            minHeap.add(num);

        for (int i = 0; i < k - 1; i++) 
            minHeap.poll(); 
        

        return minHeap.peek();
    }
}
