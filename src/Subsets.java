import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adamli on 9/1/15.
 */
public class Subsets {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int nums[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (nums == null || nums.length==0)
            return result;

        ArrayList<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);

        helper(result, list, nums, 0);

        return result;
    }

    /**
     *
     * @param result set of subsets
     * @param list  set of number that make up a subset
     * @param nums     input numbers
     * @param pos   position in S and position in list
     */
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList list, int nums[],
                       int pos) {
        // remember to create a new ArrayList for list because of the type of result
        // base case: list added into result
        result.add(new ArrayList<Integer>(list));

        // use i to loop through all numbers after position pos in S
        for (int i=pos;i<nums.length;i++) {
            list.add(nums[i]);

            // bring current list recursively and put next number in S into list
            helper(result, list, nums, i+1);

            // backtrack, remove the last number in list, so in next loop a new number will be put in list in the same
            // position
            list.remove(list.size()-1);
        }
    }
}
