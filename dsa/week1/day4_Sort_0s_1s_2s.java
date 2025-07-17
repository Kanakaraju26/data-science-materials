package week1;

public class day4_Sort_0s_1s_2s {
    public void sort012(int[] arr) {
        // code here
        int ones = 0;
        int twos = 0;
        int zeros = 0;
        
        for(int i:arr){
            if(i==1)ones++;
            if(i==2)twos++;
            if(i==0)zeros++;
        }
        int k = 0;
        while(zeros-- > 0){
            arr[k] = 0;
            k++;
        }
        
        while(ones-- > 0){
            arr[k] = 1;
            k++;
        }
        
        while(twos-- > 0){
            arr[k] = 2;
            k++;
        }
         
    }
}
