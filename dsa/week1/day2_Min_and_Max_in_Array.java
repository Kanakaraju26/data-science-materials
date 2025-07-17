package week1;
public class day2_Min_and_Max_in_Array {
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

