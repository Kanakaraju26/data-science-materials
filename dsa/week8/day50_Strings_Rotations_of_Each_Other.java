package week8;

public class day50_Strings_Rotations_of_Each_Other {
    public boolean areRotations(String s1, String s2) {
        // code here
        s1=s1+s1;
        return s1.lastIndexOf(s2)>=0;
    }
}