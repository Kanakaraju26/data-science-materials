package week8;

public class day52_Count_and_Say {
    public String countAndSay(int n) {
         if (n <= 0) return "";

        String result = "1";
        for (int i = 1; i < n; i++) {
            result = buildNext(result);
        }
        return result;
    }

    private String buildNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char currentChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(count);
                sb.append(currentChar);
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        // Append the last group
        sb.append(count);
        sb.append(currentChar);

        return sb.toString();
    }
}
