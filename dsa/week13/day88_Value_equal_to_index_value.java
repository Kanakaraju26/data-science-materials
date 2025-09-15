package week13;

import java.util.ArrayList;
import java.util.List;

public class day88_Value_equal_to_index_value {
    public List<Integer> valueEqualToIndex(List<Integer> nums) {
        // code here
        List<Integer> ls = new ArrayList<>();
        int idx=1;
        for(int i:nums){
            if(idx==i)
                ls.add(i);
            idx++;
        }
        return ls;
    }
}
