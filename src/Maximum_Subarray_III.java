import javax.xml.ws.soap.MTOM;
import java.util.ArrayList;

/**
 * Created by adamli on 10/25/15.
 */
public class Maximum_Subarray_III {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() < k) {
            return 0;
        }

        int len = nums.size();

        // first dim: sub_array index
        // second dim: number in nums index
        // max sum of nums[0~len] in k sub_arrays
        int dp[][] = new int[k][len];

        /**
         * initiation: for dp[sub_array][numbers-1]
         * if you have 1 sub-array only up to numbers i
         * it becomes a max_subarray_I
         */
        int iterMax = nums.get(0);
        for (int numbers = 1; numbers<len; numbers++) {
            int curr = nums.get(numbers);

            // make this max array curr only, ont add curr into previous max array
            iterMax = Math.max(curr, iterMax + curr);
            dp[0][numbers] = Math.max(iterMax, dp[0][numbers-1]);
        }


        /**
         * initiation: for  dp[sub_array-1][numbers-1], where number start with sub_array+1
         * split first i numbers into i sub arrays
         * that is one number one sub-array, the max sum is adding them all
         */
        dp[0][0] = nums.get(0);
        int tmp = dp[0][0];

        for (int sub_array = 1; sub_array<k; sub_array++) {
            tmp += nums.get(sub_array);
            dp[sub_array][sub_array] = tmp;
        }

        /**
         * transitive relationship
         * iterMax discuss the case when last number is taken
         * dp[sub_array][number] discuss the case whether last number should be taken
         */
        for(int sub_array = 1; sub_array<k; sub_array++) {
            /**
             * since you have to get k numbers to make k sub_array
             * initial max sum in each sub array iteration starts with
             * "getting k sub arrays and take up to k numbers"
             */
            iterMax = dp[sub_array][sub_array];
            for (int numbers = sub_array + 1; numbers<len; numbers++) {
                int curr = nums.get(numbers);

                // iterMax discuss the case when last number is taken
                iterMax = Math.max(
                        // a. when take curr number into current last sub-array
                        iterMax + curr,
                        // b. when take curr number as a new sub-array
                        dp[sub_array-1][numbers-1] + curr
                );

                /** dp[sub_array][numbers] is the global max sum
                 * include the case when curr number is not taken (curr < 0, for example)
                 */
                dp[sub_array][numbers] = Math.max(
                        // a. max sum of taking curr number, which is iterMax
                        iterMax,
                        // b. don't take curr number, which is the previous dp
                        // REMEMBER DON'T ADD CURR HERE SINCE ITS NOT TAKEN
                        dp[sub_array][numbers-1]
                );
            }
        }

        return dp[k-1][len-1];
    }

    public static void main(String args[]) {
        Maximum_Subarray_III sol = new Maximum_Subarray_III();
        int array[] = {2,-1,3,-4,5,-8,6,-7,200,-100,1000};
        int k = 5;
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int number:array) {
            nums.add(number);
        }

        System.out.println(sol.maxSubArray(nums, k));
    }
}
