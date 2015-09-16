import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adamli on 9/10/15.
 */
public class Search_for_a_Range {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // if input is empty, return [-1, -1]
        if(A == null || A.size() == 0)
            return new ArrayList<Integer>(Arrays.asList(-1, -1));

        int start = 0;
        int end = A.size() - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        // find left bound
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            // if [mid] < target, target in later half, cut [mid+1~end] from search range
            if (A.get(mid) < target) {
                start = mid;
            }else if (A.get(mid) > target){
                // if [mid] > target, target in first half, cut [0~mid-1] from search range
                end = mid;
            }else{
                /**
                 * if mid = target, keep searching for earlier left bound in first half
                 * cut [mid+1~end] from search range
                 */
                end = mid;
            }
        }

        // put left bound into result
        if(A.get(start) == target) {
            result.add(0, start);   // if left bound is [start], result = [start, ~]
        }else if(A.get(end) == target) {
            result.add(0, end); // if left bound is not [start] but [end], then result = [end, ~]
        }else {
            // if neither target = [start] or [end], result = [-1, -1]
            result.add(-1);
            result.add(-1);

            // result directly, no point to search for right bound
            return result;
        }

        // if code execution get here, there must be a left bound already
        // start with left bound
        start = result.get(0);
        end = A.size() - 1;

        // find right bound
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            // do the search binary search, but....
            if (A.get(mid) < target) {
                start = mid;
            }else if (A.get(mid) > target){
                end = mid;
            }else{
                // if target = mid, this time, we keep searching for potential right bound in later half
                // cut [0, mid-1] from search range
                start = mid;
            }
        }

        // put right bound into result
        // looking for the last occurrence of target in A (right bound), so start with [end]
        if (A.get(end) == target) {
            result.add(1, end);
        }else if(A.get(start) == target){
            // if end doesn't hit target, check start
            result.add(1, start);
        }else{
            // no hit at all, then right bound is left bound
            result.add(1, result.get(0));
        }

        return result;
    }
}
