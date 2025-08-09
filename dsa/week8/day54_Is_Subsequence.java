package week8;

public class day54_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int idx=0;
        if(s.length()==0) return true;
        if(s.length() > 0 && t.length()==0) return false;
        
        for(int i=0;i<t.length();i++){
            if(idx < s.length() && s.charAt(idx)==t.charAt(i)  ){
                idx++; 
            }
            System.out.print(idx);
        }
        return idx==s.length();
    }
}
