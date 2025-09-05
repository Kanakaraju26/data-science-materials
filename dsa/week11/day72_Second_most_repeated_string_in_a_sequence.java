package week11;

import java.util.HashMap;
import java.util.Map;

public class day72_Second_most_repeated_string_in_a_sequence {
    String secFrequent(String arr[], int N) {
        // your code here
        if (N == 1)
            return arr[0];
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int firstbig = Integer.MIN_VALUE;
        int secondb = Integer.MIN_VALUE;
        String firstbigKey = "";
        String secondbigKey = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            String key = entry.getKey();

            if (freq > firstbig) {
                secondb = firstbig; // previous max becomes second max
                secondbigKey = firstbigKey;

                firstbig = freq;
                firstbigKey = key;
            } else if (freq > secondb && freq < firstbig) {
                secondb = freq;
                secondbigKey = key;
            }
        }

        return secondbigKey;
    }
}
