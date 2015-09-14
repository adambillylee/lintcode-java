import java.util.Map;

/**
 * Created by adamlee on 15-09-12.
 */
public class Median_of_two_Sorted_Arrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;

        if (len % 2 == 0) {
            /**
             * if length of A + B is odd, median position is the avg of two middle numbers
             * ([len / 2 + 1] + [len /2]) / 2.0, make sure its float
             */
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }else{
            /**
             * if length of A+B is even, then median position is [len / 2 + 1]
             */
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }

    /**
     * @param A first array
     * @param A_start search start position in array A
     * @param B second array
     * @param B_start search start position in array B
     * @param k kth largest number that we are looking for in merged array
     * @return kth largest number in merged array
     */
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        /**
         * base case: Arrays are too short, k is too large
         */
        if (A_start >= A.length) {
            // if A is too short, median must in B
            // the Kth number in B is [start + k - 1]
            return B[B_start + k - 1];
        }
        if(B_start >= B.length) {
            // if B is too short, median must be in A
            // the Kth number in A is [start + k - 1]
            return A[A_start + k - 1];
        }

        /**
         * base case 2: k == 1
         * return return the smallest start number in both arrays
         */
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);    //[start] number, not first number
        }

        /**
         * looking for median of array A[A_start, A.length-1]
         * the largest potential index position of median is [A_start + k / 2 + 1]
         * we compare [A_start + k / 2 - 1] with A.length
         * if A.length is long enough, A_mid is median in A
         * if A.length is not long enough, then median of merged array must in B
         * set A_mid = Integer.MAX_VALUE, so we cut down the search range in B
         */
        int A_mid = A_start + k / 2 - 1 < A.length
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;

        int B_mid = B_start + k / 2 - 1 < B.length
                ? A[B_start + k /2 - 1]
                : Integer.MAX_VALUE;

        // recursive call: decide which part to cut from search range
        if (A_mid < B_mid) {
            /**
             * if median of B is larger, median of merged array cannot be in first half of remaining A
             * cut A[0~A_start + K/2] from search range
             * also, we reduce search step length (K) in half
             */
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }

}
