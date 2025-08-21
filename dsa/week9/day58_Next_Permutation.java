package week9;

public class day58_Next_Permutation {
    void nextPermutation(int[] arr) {
        
        int n = arr.length;
        
        // Step 1: find first index from right where arr[i] < arr[i+1]
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            // Step 2: find the smallest number greater than arr[i] from right side
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            
            // Step 3: swap
            swap(arr, i, j);
        }
        
        // Step 4: reverse the part after i
        reverse(arr, i + 1, n - 1);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
        
// The problem is about finding the next bigger arrangement of numbers from the given array.

// Think of it like this:
// You’re given an arrangement of numbers (a permutation).
// You need to find the next arrangement in order, just like how numbers increase when you count.
// If you are already at the last arrangement (the biggest one), you go back to the smallest arrangement (sorted ascending).

//Wrong code but can seek mistakes from here too
        
//         // code here
        
//         for(int i=0;i<arr.length-1;i--){
//             if(arr[i] > arr[i+1] && i!=arr.length-1){
//                 int temp = arr[i];
//                 int tmp = findnextbig(arr , i+1);
//                 arr[i] = arr[tmp];
//                 arr[tmp] = temp;
//                 sorti(arr,i);
//                 return;
                
//             }
//         }
//         int n = arr.length-1;
//         for(int i=0; i< arr.length/2;i++){
//           int temp = arr[i];
//             arr[i] = arr[n];
//             arr[n] = temp;
//         }
//         return;
//     }
//     static void sorti (int[] arr, int i){
//         int[] ar1 = new int[arr.length - i];
//         int idx = 0;
//         for(int j = i+1;j<arr.length;j++){
//             ar1[idx] = arr[j];
//             idx++;
//         }
//         Arrays.sort(ar1);
//         idx=0;
//         for(int j = i+1;j<arr.length;j++){
//             arr[j] = ar1[idx]; 
//             idx++;
//         }
//     }
    
//     static int  findnextbig(int[] arr, int  j){
//         int min= Integer.MAX_VALUE;
//         int idx = -1;
//         for(int i=j;i<arr.length;i++){
//             if( arr[i] > arr[j-1] && min > arr[i]){
//                 idx = i;
//                 min = arr[i];
//             }
//         }
//         return idx;
//     }
// }