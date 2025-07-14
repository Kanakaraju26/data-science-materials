package week5;

public class day34_Palindromic_Array{
    static boolean isin(int num){
         int original = num, reversed = 0;
    while (num > 0) {
        reversed = reversed * 10 + num % 10;
        num /= 10;
    }
    return original == reversed;
    }
    public static boolean isPalinArray(int[] arr) {
        // add code here.
       for(int i:arr){
           if(!isin(i)){
               return false;
           }
       }
       return true;
       
    }
}