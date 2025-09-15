package week13;

public class day89_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int j=0;
        for(int i:nums){
            if(i==target){
                return j;
            }
            j++;
        }
        return -1;
    }
}
