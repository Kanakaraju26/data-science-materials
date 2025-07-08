package week4;

import java.util.Arrays;
import java.util.HashMap;

public class day27_Array_Subset {
    public boolean isSubset(int a[], int b[]) {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: a){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i: b){
            if(map.containsKey(i)){
                if(map.get(i)==0) return false;
                else map.put(i,map.get(i)-1);
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isSubsets(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return j == b.length;
    }
}


