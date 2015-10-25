import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 10/14/15.
 */
public class Maximum_Subarray {
    public int maxSubArray(int nums[]) {
        // initialization
        int sum = nums[0];
        int max = nums[0];

        /**
         * since we have already put nums[0] into sum and max
         * we start looping at i=1
         */
        for(int i=1; i<nums.length; i++) {
            /**
             * there is a special case, nums[i] > 0
             * but previous sum < 0
             * in this case, nums[i] is max sum in this iteration
             */
            sum = Math.max(nums[i], sum + nums[i]);

            max = Math.max(sum, max);
        }

        return max;
    }
}
