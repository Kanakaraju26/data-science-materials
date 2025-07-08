package week4;

public class day26_Stock_Buy_and_Sell_Max_2_Transactions_Allowed {
public class MaxProfitTwoTransactions {
    public static int maxProfits(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        // Try every possible split point i
        for (int i = 0; i < n; i++) {
            // Max profit from day 0 to i (first transaction)
            int profit1 = maxSingleTransaction(prices, 0, i);
            // Max profit from day i+1 to end (second transaction)
            int profit2 = maxSingleTransaction(prices, i + 1, n - 1);

            maxProfit = Math.max(maxProfit, profit1 + profit2);
        }

        return maxProfit;
    }

    // Helper method to calculate max profit in a range [start..end] with one transaction
    private static int maxSingleTransaction(int[] prices, int start, int end) {
        if (start >= end) return 0;

        int minPrice = prices[start];
        int maxProfit = 0;

        for (int i = start + 1; i <= end; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }


     public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;
        if (n == 0) return 0;

        int[] leftProfits = new int[n];
        int[] rightProfits = new int[n];

        // First pass: left to right
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - minPrice);
        }

        // Second pass: right to left
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfits[i] = Math.max(rightProfits[i + 1], maxPrice - prices[i]);
        }

        // Combine profits
        int maxTotalProfit = 0;
        for (int i = 0; i < n; i++) {
            maxTotalProfit = Math.max(maxTotalProfit, leftProfits[i] + rightProfits[i]);
        }

        return maxTotalProfit;
    }

    // Test the function
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit with at most 2 transactions: " + result);
    }
}

}
