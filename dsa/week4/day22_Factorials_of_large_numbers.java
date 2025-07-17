package week4;

import java.util.ArrayList;
import java.util.Collections;

public class day22_Factorials_of_large_numbers {
    public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1); // Start with 1

        for (int i = 2; i <= n; i++) {
            multiply(res, i);
        }

        Collections.reverse(res); // Digits are in reverse
        return res;
    }

    private static void multiply(ArrayList<Integer> res, int x) {
        int carry = 0;

        for (int i = 0; i < res.size(); i++) {
            int product = res.get(i) * x + carry;
            res.set(i, product % 10); // update digit
            carry = product / 10;
        }

        while (carry > 0) {
            res.add(carry % 10);
            carry /= 10;
        }
    }
}


// ArrayList<Integer> arr = new ArrayList<>();
// if(n==0 || n==1){
//     arr.add(1);
//     return arr;
// } 
// ArrayList<Integer> res = new ArrayList<>();
// res.add(1); // Start with 1

// for (int i = 2; i <= n; i++) {
//     res.set(0,res.get(0) * i);
// }
// int mn=0;
// System.out.println(res.get(0));
// String numberStr = String.valueOf(mn);

// for (int i = 0; i < numberStr.length(); i++) {
//     char digitChar = numberStr.charAt(i);
//     int nums = digitChar - '0';
//     arr.add(nums);
// }
// return arr;
