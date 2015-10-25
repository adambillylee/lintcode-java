import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by adamli on 10/24/15.
 */
public class Maximum_Subarray_Difference {
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        //initiation for DP
        int leftMinSum[] = new int[nums.size()];
        int leftMaxSum[] = new int[nums.size()];
        // get minsum and maxsum array starting from left
        int minIter = nums.get(0);
        int maxIter = nums.get(0);
        leftMinSum[0] = nums.get(0);
        leftMaxSum[0] = nums.get(0);

        /**
         * use DP to create left minsum and maxsum array
         */
        for (int i=1; i<nums.size(); i++) {
            int curr = nums.get(i);

            /** update min and max of current iteration
             * 1. current sum = previous sum + curr number
             * 2. if pre sum < 0 and curr > 0, then curr sum is max sum
             * for minsum, same idea
             */
            minIter = Math.min(curr, curr+minIter);
            maxIter = Math.max(curr, curr+maxIter);

            /**
             * update current minsum and maxsum
             * by comparing current min and max with previous
             */
            leftMinSum[i] = Math.min(leftMinSum[i-1],minIter);
            leftMaxSum[i] = Math.max(leftMaxSum[i-1],maxIter);
        }

        //initiation for DP
        int rightMinSum[] = new int[nums.size()];
        int rightMaxSum[] = new int[nums.size()];

        // get minsum and maxsum array starting from right
        minIter = nums.get(nums.size()-1);
        maxIter = nums.get(nums.size()-1);

        rightMinSum[nums.size()-1] = nums.get(nums.size()-1);
        rightMaxSum[nums.size()-1] = nums.get(nums.size()-1);

        /**
         * user DP for find minsum and maxsum from right
         */
        for(int i=nums.size()-2; i>=0; i--) {
            int curr = nums.get(i);

            /** update min and max of current iteration
             * 1. current sum = previous sum + curr number
             * 2. if pre sum < 0 and curr > 0, then curr sum is max sum
             * for minsum, same idea
             */
            minIter = Math.min(curr, curr+minIter);
            maxIter = Math.max(curr, curr+maxIter);

            /**
             * update current by comparing min/max in iteration
             * with previous ones
             */
            rightMinSum[i] = Math.min(rightMinSum[i+1],minIter);
            rightMaxSum[i] = Math.max(rightMaxSum[i+1],maxIter);
        }

        /**
         * loop through split line of left and right
         * from 1 to nums.length-2
         * max diff = abs(left maxsum - right minsum) or abs(right maxsum - left minsum)
         */
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.size();i++) {
            int diff = Math.max(
                    Math.abs(leftMaxSum[i-1] - rightMinSum[i]),
                    Math.abs(leftMinSum[i-1] - rightMaxSum[i])
            );

            if (diff > max)
                max = diff;
        }

        return max;
    }


    public static void main (String args[]) {
        int array[] = {1, 2, -3, 1};
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int numbers:array) {
            nums.add(numbers);
        }

        Maximum_Subarray_Difference sol = new Maximum_Subarray_Difference();
        System.out.println(sol.maxDiffSubArrays(nums));
    }
}
