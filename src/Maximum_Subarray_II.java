import java.util.ArrayList;

/**
 * Created by adamli on 10/25/15.
 */
public class Maximum_Subarray_II {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // get max sum from left
        int iterMax = nums.get(0);
        int left_max_sum[] = new int[nums.size()];
        left_max_sum[0] = nums.get(0);

        for(int i=1; i<nums.size();i++) {
            int curr = nums.get(i);

            /**
             * "curr>0, iterMax<0" or not
             * take curr only (restart at current number)
             * or all numbers upto curr (don't restart)
             */
            iterMax = Math.max(curr, curr+iterMax);

            /**
             * "is max sum up to 2 bigger or max sum up to 3 bigger?"
             * count current i position or not
             */
            left_max_sum[i] = Math.max(iterMax, left_max_sum[i-1]);
        }

        // get max sum from right
        iterMax = nums.get(nums.size()-1);
        int right_max_sum[] = new int[nums.size()];
        right_max_sum[nums.size()-1] = nums.get(nums.size()-1);

        for(int i=nums.size()-2; i>=0;i--) {
            int curr = nums.get(i);

            /**
             * "curr>0, iterMax<0" or not
             */
            iterMax = Math.max(curr, curr+iterMax);

            /**
             * "add max of this iteration or keep max sum of previous iteration"
             */
            right_max_sum[i] = Math.max(iterMax, right_max_sum[i+1]);
        }

        /**
         * loop through split line of left and right
         * from i=1 to i=nums.size()-1
         */
        int max = Integer.MIN_VALUE;
        for(int i=1; i<nums.size(); i++) {
            iterMax = left_max_sum[i-1]+right_max_sum[i];

            if(iterMax > max)
                max = iterMax;
        }

        return max;
    }
}
