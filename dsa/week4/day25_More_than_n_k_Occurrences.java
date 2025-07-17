package week4;

import java.util.HashMap;
import java.util.Map;

public class day25_More_than_n_k_Occurrences {
    // Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int k) {
        // your code here,return the answer
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int cnt = 0;
        int n = arr.length/k;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>n)
                cnt++;
        }
        return cnt;
    }
}