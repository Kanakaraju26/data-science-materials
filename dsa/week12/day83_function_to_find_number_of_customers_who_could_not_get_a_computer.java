package week12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day83_function_to_find_number_of_customers_who_could_not_get_a_computer {
     public static int solve(int N, String S) {
        // code here
       Set<Character> active = new HashSet<>();
        Map<Character, Boolean> allocated = new HashMap<>();
        int occupied = 0;
        int walkedAway = 0;

        for (char ch : S.toCharArray()) {
            if (!active.contains(ch)) {
                // First occurrence (arrival)
                active.add(ch);
                if (occupied < N) {
                    occupied++;
                    allocated.put(ch, true); // got a computer
                } else {
                    walkedAway++;
                    allocated.put(ch, false); // no computer
                }
            } else {
                // Second occurrence (departure)
                active.remove(ch);
                if (allocated.get(ch)) {
                    occupied--; // free the computer only if allocated
                }
            }
        }
        return walkedAway;
    }
}