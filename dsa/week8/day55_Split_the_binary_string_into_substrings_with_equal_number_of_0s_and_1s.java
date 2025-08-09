package week8;

public class day55_Split_the_binary_string_into_substrings_with_equal_number_of_0s_and_1s {
    public static int maxSubStr(String str) {
        // Write your code here
        int cnt=0;
       int sum=0;
       for(char ch:str.toCharArray()){
           if(ch=='1'){
               sum+=1;
           }else{
               sum-=1;
           }
           if(sum==0) cnt++;
       }
       return sum!=0?-1:cnt;
    }
}
