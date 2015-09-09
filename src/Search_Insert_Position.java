/**
 * Created by adamlee on 15-09-07.
 */
public class Search_Insert_Position {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {

        // empty string, return 0
        if (A == null || A.length == 0)
            return 0;

        int start = 0;
        int end = A.length - 1;

        
        while (start + 1 < end) {   // searching for a range with size of at least 1 (stop when start +1 = end)
            int mid = (start + end ) / 2;

            // if A[mid] is target, return the insert position right after mid
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {  // if mid < target, the target must be in later half of A
                start = mid;               // cut out the first half of A by moving the START OF SEARCH RANGE to mid
            } else {                       // if not, than target is at the first half of A
                end = mid;                 // cut out the later half of A by moving the END OF SEARCH RANGE to mid
            }
        }

        /**
         * IF WE ARE LOOKING FOR FIRST INSERT POSITION
         * after previous loop, we get the very narraw range with start + 1 = end
         * now we need to find which one is the exact insert position (start, end or end + 1)
         * insert target into THE POSITION OF THE FIRST NUMBER > TARGET IN A
         */
        if (A[start] >= target) {
            /**
             * if A[start] is still bigger than target
             * that mean A[start] is the first number in A that's bigger than target
             * insert target into position [start] will push A[start] to one position later
             */
            return start;
        } else if (A[end] >= target) {  // if A[start] < target < end, A[end] will be first number > target in A
            return end;                 // put A into position [end]
        } else {                        // if target > A[end], than A[end+1] will be the first number in A > target
            return end + 1;             // put A into position [end+1]
        }


        /**
         * IF WE ARE LOOKING FOR LAST INSERT POSITION
         * insert target into THE POSOTION OF THE LAST NUMBER < TARGET IN A
         * this time we need to start looking from the end
         */
//        if (A[end] == target) {
//            return end;
//        }
//        if (A[end] < target) {
//            return end + 1;
//        }
//        if (A[start] == target) {
//            return start;
//        }
//        return start + 1;

    }
}
