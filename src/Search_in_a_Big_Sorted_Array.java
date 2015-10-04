/**
 * Created by adamli on 10/4/15.
 */
public class Search_in_a_Big_Sorted_Array {
    /**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;

        int start = 0;
        int end = 0;

        // reverse binary search for rough latest end index
        while (end < A.length && A[end] < target)
            end = end * 2 + 1;

        // modified version of binary search
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            /**
             * since we are looking for first matching index
             * this mid at worst case could be at the end of a matching sequence
             * cut [mid+1~end] from search range and keep looking for earlier matches
             */
            if (target == A[mid]) {
                end = mid;
            }else if (target > A[mid]) {
                start = mid;
            }else {
                end = mid;
            }
        }

        /**
         * since we are looking for first matching index
         * we check start first, if start matches, we return it first
         */
        if (target == A[start]) {
            return start;
        }else if (target == A[end]) {
            return end;
        }else{
            return -1;
        }
    }
}
