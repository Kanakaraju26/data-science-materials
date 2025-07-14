package week5;

import java.util.ArrayList;
import java.util.Collections;

public class day30_Chocolate_Distribution_Problem{
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        int strt = 0;
        int lst = strt+m - 1 ;
        for(int i:arr){
            if(arr.size() > lst){
                min = Math.min(min,arr.get(lst) - i);
                strt++;
                lst++;
            }
        }
        return min;
    }
}
