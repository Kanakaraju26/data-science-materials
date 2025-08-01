package week7;

import java.util.LinkedHashMap;
import java.util.Map;

public class day49_Repeated_Character {
    char firstRep(String S) {
        // your code here
       Map<Character, Integer> map = new LinkedHashMap<>();
         for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1) return entry.getKey();
        }
        return '#';
    }
}
