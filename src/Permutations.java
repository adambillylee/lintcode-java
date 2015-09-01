import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adamli on 8/31/15.
 */
public class Permutations {
    /**
     * @param S: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> S) {
        // initiate result with an empty arraylist to make sure there is an empty set
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(new ArrayList<ArrayList<Integer>>());

        // if input is null, return empty result
        if(S == null || S.size()==0)
            return result;

        // make sure all input numbers are sorted
        Collections.sort(S);

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, S);

        return result;
    }

    /**
     *
     * @param result set of permutations
     * @param list  set of numbers in one permutation
     * @param S     input numbers
     */
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S) {

        // base case: if the length of list can make up a permutation, add it to result
        if (list.size() == S.size()) {
            // since result is an ArrayList of Arraylist<Integer>, make sure to make a new ArrayList for list object
            result.add(new ArrayList<Integer>(list));
            return; // return for backtrack when a new permutation is added into result
        }

        // any number could be added into list, so use i to loop through all elements in S every time
        for (int i=0;i<S.size();i++) {
            // make sure each numbers in a permutation are unique
            if (list.contains(S.get(i))) {
                continue;
            }

            // add element into list
            list.add(S.get(i));
            // push new list with one more number back into recursion
            helper(result, list, S);

            /**
             * backtrack when list is added into result
             * remove the very last number from list, so in the next loop iteration,
             * a new number can be added in the same position in the list, to make a new permutation
             */
            list.remove(list.size()-1);
        }
    }

    public static void main(String args []) {
        ArrayList S = new ArrayList();
        S.add(1);
        S.add(3);
        S.add(5);
        S.add(7);

        Permutations sol = new Permutations();
        ArrayList<ArrayList<Integer>> result  = sol.permute(S);

        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
