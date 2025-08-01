package week7;

public class day47_Reverse_String {
    public void reverseString(char[] s) {
        for(int i = 0 ; i < (s.length/2) ; i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
