import java.util.*;
class Solution {
    public static int findUnion(int a[], int b[]) {
        // code here
        Set<Integer> s = new HashSet<>();
        for (int i: a){
            s.add(i);
        }
        for (int i: b){
            s.add(i);
        }
        
        return s.size();
        
    }
}