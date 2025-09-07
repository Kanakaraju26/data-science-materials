package week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class day79_Print_Anagrams_Together {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String, List<String>> map = new LinkedHashMap<>(); // preserves order
        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // sorted version
            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (List<String> group : map.values()) {
            res.add(new ArrayList<>(group));
        }
        return res;
        // return new ArrayList<>(map.values());
    }
}
// Map<String, List<String>> map = new LinkedHashMap<>();

// String s = "eat";
// String key = "aet"; // sorted

// // Key does not exist yet
// map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
// // map now: {"aet" : ["eat"]}

// s = "tea";
// key = "aet"; // same key as before

// // Key exists, returns existing list ["eat"]
// map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
// // map now: {"aet" : ["eat", "tea"]}

// ✅ TL;DR

// computeIfAbsent → get the list for the key, or create a new one if missing.

// .add(s) → add the current string to the list for that key.