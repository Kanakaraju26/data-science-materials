package week3;

import java.util.ArrayList;

public class day20_Alternate_Positive_Negative {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) pos.add(num);  
            else neg.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        boolean turnPos = true;

        // Alternate insertion
        while (i < pos.size() && j < neg.size()) {
            if (turnPos) {
                result.add(pos.get(i++));
            } else {
                result.add(neg.get(j++));
            }
            turnPos = !turnPos;
        }

        // Add remaining positives
        while (i < pos.size()) {
            result.add(pos.get(i++));
        }

        // Add remaining negatives
        while (j < neg.size()) {
            result.add(neg.get(j++));
        }

        // Copy result back to original list
        for (int k = 0; k < arr.size(); k++) {
            arr.set(k, result.get(k));
        }
    }
}