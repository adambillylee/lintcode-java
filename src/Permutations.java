import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by adamli on 8/31/15.
 */
public class Permutations {
    /**
     * @param S: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(new ArrayList<ArrayList<Integer>>());
        if(S == null || S.size()==0)
            return result;

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, S);

        return result;
    }

//    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
//                       ArrayList<Integer> S) {
//        if (list.size() == S.size()) {
//            System.out.println("Added into result: "+ list);
//
//            result.add(new ArrayList<Integer>(list));
//            return;
//        }
//
//        for (int i = 0; i < S.size(); i++) {
//            if (list.contains(S.get(i))) {
//                System.out.println(S.get(i)+" is already in list, list="+list);
//
//                continue;
//            }
//
//            System.out.println("Added into list: "+S.get(i)+", i="+i);
//
//            list.add(S.get(i));
//            helper(result, list, S);
//            list.remove(list.size() - 1);
//
//            System.out.println("Backtrack: removed list=" + list);
//        }
//    }

    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S) {
        if (list.size() == S.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i=0;i<S.size();i++) {
            if (list.contains(S.get(i)))
                continue;

            list.add(S.get(i));
            helper(result, list, S);
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
