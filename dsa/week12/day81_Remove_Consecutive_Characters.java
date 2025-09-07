package week12;

public class day81_Remove_Consecutive_Characters {
    public String removeConsecutiveCharacter(String s) {
        // code here
        StringBuilder sb = new StringBuilder(s);

        int i = 1; // start from second character
        while (i < sb.length()) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.delete(i, i + 1); // remove current character
                // don’t increment i, because new char at i needs re-check
            } else {
                i++; // move to next
            }
        }

        return sb.toString();

        // String news = "";
        // news+=s.charAt(0)+"";
        // int i=1;
        // while(i<s.length()){
        // // System.out.println(s.charAt(i) + " " + i);
        // if(news.charAt(news.length()-1)==s.charAt(i)){
        // i++;
        // continue;
        // }else{
        // news+=s.charAt(i)+"";
        // i++;
        // }
        // }
        // return news;
    }
}
