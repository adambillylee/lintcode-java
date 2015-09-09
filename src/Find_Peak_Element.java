/**
 * Created by adamlee on 15-09-08.
 */
public class Find_Peak_Element {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // if empty array, return -1
        if (A == null || A.length == 0)
            return -1;

        // since first and last element will not be peak, loop through 2nd to 2nd last elements in A
        int start = 1;
        int end = A.length - 2;

        // search for narrow range where either start or end is the peak element
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            // if A[mid] < A[mid-1], peak is at left hand side
            if (A[mid] < A[mid]-1) {
                end = mid;  // cut [mid+1 ~ end] out of search range
            }else if (A[mid] < A[mid+1]) {  // if A[mid] < A[mid+1], peak at right hand side
                start = mid;    // cut [0 ~ start] out of search range
            }else {
                end = mid;      // if A[mid] adjacent element, since we look for 1st peak possible, search to left
            }
        }

        // return the index of larger one in A[start] and A[end]
        if (A[start] < A[end]) {
            return end;
        }else{
            return start;
        }
    }
}
