package week11;

public class day71_Min_Number_of_Flips {
    public int minFlips(String s) {
        // Code here
        if(s.length()==1) return 0;
        int count0 = 0;
        int count1 = 0;
        
        char sequence = '0';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=sequence){
                count0++;
            }
            if(sequence == '1')
                sequence = '0';
            else
                sequence = '1';
        }
        
        sequence = '1';
        for(int i=0;i<s.length();i++){
            // System.out.println(s.charAt(i)+ " " +sequence + " " + count1);
            if(s.charAt(i)!=sequence){
                count1++;
            }
            if(sequence == '1')
                sequence = '0';
            else
                sequence = '1';
        }
        // System.out.println(count0 +" " + count1);
        
        return Math.min(count0,count1);
    }
    public int minFlipss(String s) {
        int count0 = 0; // flips if pattern starts with '0'
        int count1 = 0; // flips if pattern starts with '1'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Expected char at i for pattern "010101..."
            char expected0 = (i % 2 == 0) ? '0' : '1';
            // Expected char at i for pattern "101010..."
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (c != expected0) count0++;
            if (c != expected1) count1++;
        }

        return Math.min(count0, count1);
    }
}

