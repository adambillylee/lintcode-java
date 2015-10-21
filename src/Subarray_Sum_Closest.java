import com.sun.tools.javac.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by adamli on 10/19/15.
 */
public class Subarray_Sum_Closest {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList res = new ArrayList();

        if (nums == null || nums.length == 0)
            return null;

        if (nums.length == 1){
            res.add(0);
            res.add(0);
            return res;
        }

        // build Pair arraylist to record all incremental sums and their indexes
        Pair sum[] = new Pair[nums.length+1];

        // initiate first element
        sum[0] = new Pair(0,0);

        /**
         * create incremental sum list
         * sum[2] = new Pair(sum[1].sum + nums[1], 2)
         */
        for (int i=1; i<nums.length+1; i++) {
            sum[i] = new Pair(sum[i-1].sum + nums[i-1], i);
        }

        // sort incremental sum list
        Arrays.sort(sum);

        // compare adjacent elements in incremental sum list, get min difference
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int i=0; i< nums.length; i++) {
            if (ans > sum[i+1].sum - sum[i].sum) {
                ans = sum[i+1].sum - sum[i].sum;

                /**
                 * from incremental sum index to nums index:
                 * for example, sum5 - sum2 = 3rd, 4th, 5th, or nums[2~4]
                 * start index = smaller sum index
                 * end index = larger sum index + 1
                 */
                start = Math.min(sum[i+1].index, sum[i].index);
                end = Math.max(sum[i+1].index, sum[i].index) - 1;
            }
        }

        res.add(start);
        res.add(end);

        return res;
    }

    class Pair implements Comparable<Pair> {
        int sum;
        int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }


    public static void main(String[] args) {
        Subarray_Sum_Closest sol = new Subarray_Sum_Closest();
        int[] nums = {-3, 1, 1, -3, 5};
        ArrayList res = sol.subarraySumClosest(nums);

        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}
