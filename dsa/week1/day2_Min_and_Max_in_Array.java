package week1;

class Solution {
    public void getMinMax(int[] arr) {
        // Code Here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if (min > arr[i]){
                min = arr[i];
            }
            if (max < arr[i]){
                max = arr[i];
            }
        }

        System.out.println(min+ "" +max);
        
        return;
    }

    
}
