package week13;

import java.util.ArrayList;
import java.util.Arrays;

public class day86_Recursively {
    public static ArrayList<ArrayList<String>> sentences(String[][] list) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>> ();

       helper(list, 0, "", ans);
       return ans;

   }

   private static void helper(String[][] list, int i, String s, ArrayList<ArrayList<String>> ans) {

       if (i == list.length) {
           String[] temp = s.split(",");
           ans.add(new ArrayList<String> (Arrays.asList(temp)));
           return;
       }

       String[] arr = list[i];

       for (String j: arr) {

           helper(list, i + 1, s + j + ",", ans);
       }

   }
}
