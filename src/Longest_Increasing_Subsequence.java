/**
 * Created by adamli on 9/27/15.
 */
public class Longest_Increasing_Subsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        /**
         * state definition:
         * f[i] = max increasing sequence length up to s[i]
         */
        int f[] = new int[nums.length];

        int global_max = 0;

        /**
         * recurrence relationship:
         * use i to loop through each all characters up to index i
         * use j to loop through 0~i-1, if there is an increasing sequence (nums[j] < nums[i])
         * f[i] is the maximum of current f[i] value, or f[j]+1
         */
        for (int i=0; i< nums.length; i++) {
            f[i] = 1;   //since string of length 1 has max increasing sequence length of 1
            for (int j=0; j<i; j++) {
                if (nums[j] <= nums[i])
                    f[i] = Math.max(f[j]+1, f[i]);
            }

            // update global max with "increasing sequence length up to i"
            if (global_max < f[i])
                global_max = f[i];
        }

        return global_max;
    }
}
