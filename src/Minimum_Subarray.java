import java.util.ArrayList;

/**
 * Created by adamli on 10/14/15.
 */
public class Minimum_Subarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // create sum array, where sum[i] = sum of first i numbers
        int sum[] = new int[nums.size()+1];

        // sum of first 0 number is 0
        sum[0] = 0;

        /**
         * sum[i] = sum[i-1] + ith number (num[i-1])
         */
        for(int i=1; i<nums.size()+1; i++) {
            sum[i] = sum[i-1] + nums.get(i-1);
        }

        /**
         * sum[i+1~j] = sum[j] - sum[i]
         * sum[0] = 0 so no need to worry about left boundary
         */
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.size();i++) {
            for (int j=i+1; j<nums.size()+1; j++) {
                if (sum[j] - sum[i] < min)
                    min = sum[j] - sum[i];
            }
        }

        return min;
    }
}
