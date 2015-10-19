/**
 * Created by adamli on 10/17/15.
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null && prices.length == 0)
            return 0;

        /**
         * use pivit point i to cut prices into two parts
         * left = profit from 0 to i
         * right = profit from i to end (you can buy and sell at same point
         * so i are in both part)
         * maxProfit = left + right
         */
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            int left = helper(prices, 0, i);
            int right = helper(prices, i, prices.length-1);

            if (left+right > maxProfit)
                maxProfit = left+right;
        }

        return maxProfit;
    }

    public int helper(int[] prices, int start, int end) {
        // base case
        if (start == end)
            return 0;

        /**
         * initialization
         * start checking min value so from prices[start]
         * and the worst case profit is do nothing and get 0
         */
        int min = prices[start];
        int profit = 0;

        /**
         * in this case i could = end
         * there is a valid case that there is only 2 numbers in the loop:
         * prices[start] and prices[end], where start + 1 = end
         */
        for (int i=start; i<=end; i++) {
            profit = Math.max(profit, prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
