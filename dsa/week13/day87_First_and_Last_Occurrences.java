package week13;

import java.util.ArrayList;

public class day87_First_and_Last_Occurrences {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int first = -1;
        int second = -1;
        for(int i=0;i<arr.length;i++){
            if(first==-1 && arr[i]==x){
                first = i;
                second = i;
            }else if(arr[i]==x){
                second = i;
            }
        }
         ArrayList<Integer> myList = new ArrayList<>();

        myList.add(first);
        myList.add(second);
        return myList;
    }
}
