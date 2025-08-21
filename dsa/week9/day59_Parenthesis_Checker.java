package week9;

public class day59_Parenthesis_Checker {
    static boolean isBalanced(String s) {
        // code here
        if(s.length()==1 || s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}') return false;
        
        String open = "";
        
        for(char c: s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                open += c +"";
                //  System.out.println(open + " o");
            }else{
                if(open.length()==0) return false;
                // System.out.println(c + " " + open.charAt(open.length()-1));
                if((c==')' && open.charAt(open.length()-1) == '(') || (c=='}' && open.charAt(open.length()-1) == '{') || (c==']' && open.charAt(open.length()-1) == '[')){
                    // System.out.println(open + " og");
                    open = open.substring(0, open.length()-1) + open.substring(open.length()-1 + 1);
                    // System.out.println(open + " notog");
                }else{
                    return false;
                }
            }
        }
        if(open.length() == 0) return true;
        return false;
    }
}
