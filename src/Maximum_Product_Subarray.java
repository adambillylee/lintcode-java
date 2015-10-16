/**
 * Created by adamli on 10/15/15.
 */
public class Maximum_Product_Subarray {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        /**
         * state definition:
         * min[i] = min prod in nums[0~i-1]
         * max[i] = max prod in nums[0~i-1]
         */
        int min[] = new int[nums.length];
        int max[] = new int[nums.length];

        min[0] = max[0] = nums[0];

        int result = nums[0];

        for (int i=1; i<nums.length; i++) {
            /**
             * if current number > 0
             * then max array prod = max with in previous max array sum and current number
             * since previous max could be negative, need to compare it with current number
             */
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i-1]);
                min[i] = Math.min(nums[i], nums[i] * min[i-1]);
            }else if (nums[i] < 0) {
                /**
                 * if current num is negative, multiply it with previous min will get you current max
                 */
                max[i] = Math.max(nums[i], nums[i] * min[i-1]);
                min[i] = Math.min(nums[i], nums[i] * max[i-1]);
            }

            // update result for every number iterated through
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
