/**
 * Created by adamli on 10/17/15.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        /**
         * you can always sell stock when later point > previous point
         */
        for (int i=0; i<prices.length-1;i++) {
            int diff = prices[i+1] - prices[i];

            if (diff > 0) {
                profit += diff;
            }
        }

        return profit;
    }
}
