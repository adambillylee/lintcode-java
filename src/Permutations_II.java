import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by adamli on 9/1/15.
 */


public class Permutations_II {
    /**
     *
     * @param nums input numbers
     * @return set of unique permutations
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // initiate result with an empty arraylist to make sure there is an empty set
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(new ArrayList<ArrayList<Integer>>());

        // if input is null, return empty result
        if(nums == null || nums.size()==0)
            return result;

        // make sure all input numbers are sorted
        Collections.sort(nums);

        int visited[] = new int[nums.size()];

        ArrayList<Integer> list = new ArrayList<Integer>();

        helper(result, list, nums, visited);

        return result;
    }

    /**
     *
     * @param result set of unique permutations
     * @param list  set of number that builds up the current permutation
     * @param nums  input numbers
     * @param visited   set of flags that indicate the number in position i is being used in list (visited[i]=1)
     *                  or not (visited[i]=0)
     */
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums,
                       int[] visited) {

        // base case: the condition to add list into result
        if (list.size() == nums.size()) {
            // since result is an ArrayList of Arraylist<Integer>, make sure to make a new ArrayList for list object
            result.add(new ArrayList<Integer>(list));
            return;
        }

        long previous = Long.MIN_VALUE;
        // use i to loop through all elements in nums
        for (int i=0;i<nums.size();i++) {
            /**
             * skip a number in one of 2 cases
             * 1. when number (i) is visited
             * 2. when number (i) is as same as number in previous iteration
             */
            if (visited[i] == 1 || previous == nums.get(i)){
                continue;
            }

            previous = nums.get(i);
            list.add(nums.get(i));
            visited[i] = 1;
            helper(result, list, nums, visited);

            /**
             * backtrack when list is added into result
             * remove the very last number from list, so in the next loop iteration,
             * a new number can be added in the same position in the list, to make a new permutation
             */
            list.remove(list.size()-1);

            // since the permutation is already added into result, fresh visited flag for this number
            visited[i] = 0;
        }
    }

    public static void main(String args []) {
        ArrayList S = new ArrayList();
        S.add(1);
        S.add(3);
        S.add(1);
        S.add(7);

        Permutations_II sol = new Permutations_II();
        ArrayList<ArrayList<Integer>> result  = sol.permuteUnique(S);

        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}


