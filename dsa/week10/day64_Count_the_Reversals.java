package week10;

import java.util.Stack;

public class day64_Count_the_Reversals {
    public int countMinReversals(String s) {
        // code here
        if(s.length()%2!=0) return -1;

        Stack<Character> stack = new Stack<>();
        int reversals = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') {
                stack.push(c);
            } else { // c == '}'
                if (!stack.isEmpty() && stack.peek() == '{') {
                    // Matched pair found
                    stack.pop();
                } else {
                    // Unmatched closing bracket, push onto stack
                    stack.push(c);
                }
            }
        }

        // Count remaining unmatched brackets
        int open = 0, close = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                open++;
            } else {
                close++;
            }
        }

        // Minimum reversals formula
        reversals += (open + 1) / 2 + (close + 1) / 2;

        return reversals;
    }
}
