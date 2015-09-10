/**
 * Created by adamli on 9/9/15.
 */
public class Search_in_Rotated_Sorted_Array {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // return -1 if A is null
        if (A == null || A.length == 0)
            return -1;

        int start = 0;
        int end = A.length - 1;

        // look for a narrow range (end - start =1) where target within start and end
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            /**
             * mid could be either in 1st or 2nd increasing interval in rotated array
             * if A[start] < A[mid], then its in 1st increasing interval of rotated array
             */
            if (A[start] < A[mid]) {
                /**
                 * if mid is in first increasing interval, rotated array can be horizontally split into two parts
                 * ALWAYS CHOOSE INCREASING PART AS IF CONDITION, SINCE WE ARE SURE A[START] <= TARGET <= A[MID]
                 * HORIZONTALLY IF START <= TARGET <= MID
                 * IF YOU CHOOSE THE OTHER PART, the value of A[MID] COULD EITHER BE GREATER OR LESS THAN TARGET
                 * the 1st part is increasing interval [start ~ mid], if target is in it, cut [mid+1~end] from searching
                 * by moving end to mid
                 */
                if(A[start] <= target && target <= A[mid]) {
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                /**
                 * if mid is in 2nd increasing interval of rotated array
                 * the 1st part is [start~mid], but its not increasing interval, A[mid] could be greater or less than
                 * target
                 * so we have to use 2nd part [mid~end] as if condition, if target is in it, we are sure that
                 * A[mid] <= target <= A[end], end we can cut [start~mid-1] from searching by moving start to mid
                 */
                if(A[mid] <= target && target <= A[end]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        /**
         * since we are looking for 1st occurrence, start with comparing A[start] with target
         * and A[end] second, remember to return -1 when nothing can be found
         */
        if (A[start] == target) {
            return start;
        }else if (A[end] == target) {
            return end;
        }else{
            return -1;
        }
    }
}
