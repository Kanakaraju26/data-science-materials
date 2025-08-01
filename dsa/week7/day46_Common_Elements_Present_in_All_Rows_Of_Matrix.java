package week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class day46_Common_Elements_Present_in_All_Rows_Of_Matrix {
    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
       int rows = mat.size();

        // Map to store element and how many rows it has appeared in
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Step 1: Add all unique elements from the first row to the map with count 1
        HashSet<Integer> firstRowSet = new HashSet<>(mat.get(0));
        for (int num : firstRowSet) {
            countMap.put(num, 1);
        }

        // Step 2: For remaining rows
        for (int i = 1; i < rows; i++) {
            HashSet<Integer> currentRowSet = new HashSet<>(mat.get(i)); // remove duplicates in row
            for (int num : currentRowSet) {
                // Only increment if it has appeared in all previous rows
                if (countMap.containsKey(num) && countMap.get(num) == i) {
                    countMap.put(num, i + 1);
                }
            }
        }

        // Step 3: Collect elements present in all rows
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == rows) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
