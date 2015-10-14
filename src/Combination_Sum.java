import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 10/13/15.
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(result, new ArrayList<Integer>(), candidates, 0, target);

        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list,
                       int[] candidates, int pos, int target) {

        //base case: target = 0
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        /**
         * use prev to record previous candidate
         */
        int prev = -1;
        for (int i=pos; i<candidates.length; i++) {
            /** target is not large enough for more of current candidate
             * there is no need to search for even larger candidates
             */
            if (candidates[i] > target) {
                return;
            }

            /**
             * if prev is not initiated, than current candidate is not updated
             * after backtrack
             * update current candidate to next one
             */
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }

            // recursion template, add curr candidate to list
            list.add(candidates[i]);

            /**
             * recursive call with updated index position
             * and reduced target
             * DON'T UPDATE target = target - candidates[i], SINCE TARGET
             * VALUE WILL BE USED AFTER BACKTRACK IN BASE CASE
             */
            helper(result, list, candidates, i, target-candidates[i]);

            /**
             * backtrack
             * update prev to be curr candidate
             * let next iteration know candidate need to be updated after backtrack
             */
            prev = candidates[i];

            // template, remove last list element
            list.remove(list.size()-1);
        }
    }
}
