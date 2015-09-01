import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adamli on 8/30/15.
 */
public class Subsets_II {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        Collections.sort(S);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        helper(result, list, S, 0);

        return result;
    }

    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
                       ArrayList<Integer> S, int pos) {
        printHelper(pos);
        System.out.println("List added into result: " + list);
        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i<S.size(); i++) {
            if(i != pos && S.get(i) == S.get(i-1))
                continue;

            printHelper(pos);
            System.out.printf("Element added into list: %d\n", S.get(i));
            list.add(S.get(i));
            helper(result, list, S, i + 1);

            printHelper(pos);
            System.out.println("BackTrack: pos=" + pos + ", i="+i);
            System.out.println("Element removed from list: " + list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

    }

    public void printHelper(int pos) {
        for (int i=pos; i>0; i--) {
            System.out.print("-->|");
        }
    }

    public static void main(String [] args){
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(1);
        S.add(2);
        S.add(3);
        S.add(4);

        Subsets_II sol = new Subsets_II();
        ArrayList<ArrayList<Integer>> result = sol.subsetsWithDup(S);

        for (int i=0;i<result.size();i++) {
            System.out.print(result.get(i));
        }
    }
}
