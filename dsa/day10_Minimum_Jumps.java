class Solution {
    static int minJumps(int[] arr) {
        // code here
        for(int i = 1; i < arr.length;i++){
            arr[i] = Math.max(arr[i] , arr[i-1]-1);
        }
        
        int count = 0,ind = 0;
        while(ind  < arr.length-1){
            if(arr[ind] ==0) return -1;
            ind = ind + arr[ind];
            count++;
        }
        return count;
    }
}