package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        int size1 = arr1.size();
        int size2 = arr2.size();
        int size3 = arr3.size();
        
        int biggestlist = (size1 > size2) && (size1 > size3) ? size2 > size3 ? size3 : size2 : size2 > size1 && size2 > size3 ? size3 > size1 ? size1: size3 : size3;
        List<Integer> ls = new ArrayList<>();
        if(size1==biggestlist){
            for(int num : arr1){
                if(arr2.contains(num) && arr3.contains(num) && !ls.contains(num)){
                    ls.add(num);
                }
            }
        }else if(size2==biggestlist){
            for(int num : arr2){
                if(arr1.contains(num) && arr3.contains(num) && !ls.contains(num)){
                    ls.add(num);
                }
            }
        }else{
            for(int num : arr3){
                if(arr2.contains(num) && arr1.contains(num) && !ls.contains(num)){
                    ls.add(num);
                }
            }
        }
        Collections.sort(ls);
        return ls;
        
    }
}

//Optimized code

// class Solution {
//     public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
//         int i = 0, j = 0, k = 0;
//         List<Integer> result = new ArrayList<>();

//         while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
//             int a = arr1.get(i);
//             int b = arr2.get(j);
//             int c = arr3.get(k);

//             // If all three elements are equal
//             if (a == b && b == c) {
//                 // Avoid duplicates in result
//                 if (result.isEmpty() || result.get(result.size() - 1) != a) {
//                     result.add(a);
//                 }
//                 i++;
//                 j++;
//                 k++;
//             }
//             // Move the pointer that has the smallest value
//             else if (a < b) {
//                 i++;
//             } else if (b < c) {
//                 j++;
//             } else {
//                 k++;
//             }
//         }

//         if (result.isEmpty()) {
//             result.add(-1);
//         }

//         return result;
//     }
// }

//another possible way

// public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
//     List<Integer> base = arr1;
//     if (arr2.size() < base.size()) base = arr2;
//     if (arr3.size() < base.size()) base = arr3;

//     List<Integer> result = new ArrayList<>();
//     for (int num : base) {
//         if (arr1.contains(num) && arr2.contains(num) && arr3.contains(num) && !result.contains(num)) {
//             result.add(num);
//         }
//     }
//     Collections.sort(result);
//     return result.isEmpty() ? Arrays.asList(-1) : result;
// }
