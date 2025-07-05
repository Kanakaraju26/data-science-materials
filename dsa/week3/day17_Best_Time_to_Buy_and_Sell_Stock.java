package week3;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < n){
                n = prices[i];
            }else{
                max = Math.max(prices[i] - n ,max);
            }
        }
        return max;
    }
}