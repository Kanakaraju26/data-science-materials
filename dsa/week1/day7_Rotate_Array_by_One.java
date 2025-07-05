package week1;

class Solution {
    public void rotate(int[] arr) {
        // code here
        if(arr.length==1) return;
        if(arr.length==2){
            int temp = arr[1];
            arr[1] = arr[0];
            arr[0] = temp;
            return;
        }
        
        // chatgpt
        int temp=arr[arr.length-1];
        for(int i=arr.length-1; i>0; i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;
        return;

        //my solution 
        // int last = arr[arr.length-1];
        // int temp = arr[0];
        // for (int i=0;i<arr.length;i++){
        //     temp = temp + arr[i];
        //     arr[i] = temp - arr[i];
        //     temp = temp - arr[i];
        // }
        // arr[0] = last;
        //  return;
    }
}