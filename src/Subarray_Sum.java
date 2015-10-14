import java.util.ArrayList;

/**
 * Created by adamli on 10/14/15.
 */
public class Subarray_Sum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ArrayList result = new ArrayList();

        // sum[i] = sum of first i numbers, sum[0] = sum of no numbers = 0, sum[1] = nums[0]
        int sum[] = new int[nums.length+1];

        sum[0] = 0;
        sum[1] = nums[0];

        for (int i=2; i<nums.length+1; i++) {
            /**
             * since sum[0] = 0, every sum[i] = previous sum + ith number (nums[i-1])
             */
            sum[i] = sum[i-1] + nums[i-1];
        }

        /**
         * if there are 2 identical sums, that means the numbers in between add up to 0
         * if sums[1] == sums[4], then nums[1] + .. + nums[3] == 0
         * if sums[i] == sum[j], then nums[i] + ...+ nums[j-1] == 0
         */
        for (int i=0; i<nums.length;i++) {
            for (int j=i+1; j<nums.length+1;j++) {
                if (sum[i] == sum[j]) {
                    result.add(i);
                    result.add(j-1);
                    return result;
                }
            }
        }

        return null;
    }
}
