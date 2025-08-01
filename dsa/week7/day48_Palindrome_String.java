package week7;

public class day48_Palindrome_String {
    boolean isPalindrome(String s) {
        // code here
        for(int i=0;i<(s.length()/2);i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
