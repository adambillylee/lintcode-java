/**
 * Created by adamli on 10/16/15.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        // the worse case you can don't do anything and get 0 profit
        int profit = 0;

        // set min value to be the first price
        int min = prices[0];

        for (int i=1; i<prices.length;i++) {
            /**
             * DP, track profit instead of max value to reduce O(n^2) to O(n)
             */
            profit = Math.max(profit, prices[i]-min);

            // since profit calculation need min price so far, so update min every time
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
