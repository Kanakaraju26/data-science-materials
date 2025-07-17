package week1;

public class day1_Reverse_an_Array {
    public void reverseArray(int arr[]) {
        // code here
        if(arr.length==1) return;
        int k = arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            int temp1 = arr[i];
            arr[i] = arr[k];
            arr[k] = temp1;
            k--;
        }
        return;
    }
}