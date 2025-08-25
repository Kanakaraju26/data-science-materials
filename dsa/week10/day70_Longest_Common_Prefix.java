package week10;

public class day70_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String s = strs[0];
        for(int i=1;i<strs.length;i++){
            String prefix = "";
            String temp = strs[i];
            for(int j=0;j<Math.min(temp.length(),s.length());j++){
                if(s.charAt(j)==temp.charAt(j)){
                    prefix+=s.charAt(j) +"";
                }else{
                    break;
                }
            }
            if(prefix!="") 
                s = prefix;
            else
                return "";
        }
        return s;
    }
    public String longestCommonPrefixx(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); // character from the first string

            for (int j = 1; j < strs.length; j++) {
                // Stop if we reach the end of a string or find a mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0]; // all characters matched
    }
}
