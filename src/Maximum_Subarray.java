import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 10/14/15.
 */
public class Maximum_Subarray {
    public int maxSubArray(ArrayList<Integer> nums) {
        /** maximum sub-array sum
         *  the max sub-array sum could be any elements
         *  if all elements in nums is negative, there could be a case where max_subSum < 0
         *  so we have to initiate with Integer.MIN_VALUE
         */
        int max_subSum = Integer.MIN_VALUE;

        // sum from 0 to current position
        int currSum = 0;

        // minimum sum from 0 to current position
        int minSum = 0;

        for (int i=0;i<nums.size();i++) {
            // update current sum
            currSum += nums.get(i);

            // max sub array sum = current sum - min sum from 0 to current position or current max_subSum
            max_subSum = Math.max(max_subSum, currSum - minSum);

            // update minimum sum so far
            minSum = Math.min(minSum, currSum);
        }

        return max_subSum;
    }
}
