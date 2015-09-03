import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by adamli on 9/1/15.
 */
public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (S == null || S.size()==0)
            return result;

        ArrayList<Integer> list = new ArrayList<Integer>();

        Collections.sort(S);

        helper(result, list, S, 0);

        return result;
    }

    /**
     *
     * @param result set of subsets
     * @param list  set of number that make up a subset
     * @param S     input numbers
     * @param pos   position in S and position in list
     */
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList list, ArrayList<Integer> S,
                       int pos) {
        // remember to create a new ArrayList for list because of the type of result
        // base case: list added into result
        result.add(new ArrayList<Integer>(list));

        // use i to loop through all numbers after position pos in S
        for (int i=pos;i<S.size();i++) {
            list.add(S.get(i));

            // bring current list recursively and put next number in S into list
            helper(result, list, S, i+1);

            // backtrack, remove the last number in list, so in next loop a new number will be put in list in the same
            // position
            list.remove(list.size()-1);
        }
    }

    public static void main(String [] args){
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(1);
        S.add(2);
        S.add(3);
        S.add(4);

        Subsets sol = new Subsets();
        ArrayList<ArrayList<Integer>> result = sol.subsets(S);

        for (int i=0;i<result.size();i++) {
            System.out.print(result.get(i));
        }
    }
}
