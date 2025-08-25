package week10;

import java.util.HashMap;
import java.util.Map;

public class day68_Roman_Number_to_Integer {
    public int romanToDecimal(String s) {
        // code here
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;  // keeps track of the previous (right) value

        // Start from the rightmost character
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));
            // System.out.println(current + " c");
            // System.out.println(prevValue + " p");
            // System.out.println(total + " t");
            
            // If current is less than previous, subtract; else add
            if (current < prevValue) {
                total -= current;
            } else {
                total += current;
            }

            // Update previous value
            prevValue = current;
        }

        return total;
    }
}
