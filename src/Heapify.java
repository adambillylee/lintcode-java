/**
 * Created by adamli on 10/27/15.
 */
public class Heapify {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null || A.length==0)
            return;

        /**
         * go through all non-leaf nodes in heap
         * heapify every single sub-heap from bottom up
         */
        int first_non_leaf = (A.length / 2) - 1;
        for(int root=first_non_leaf; root>=0; root--) {
            helper(A, root);
        }
    }

    public void helper(int[] A, int root) {
        // define left and right index
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        int len = A.length;

        // initiate min index on root
        int min = root;

        // min could be on left or right
        if (left<len && A[left] < A[min])
            min = left;

        if (right<len && A[right] < A[min])
            min = right;

        if (min == root)
            return;

        /** if min is on sub-node instead of root
         * swap sub node to root
         * and apply local-heapify helper on min node
         */
        if (min != root) {
            swap(A, min, root);
            helper(A, min);
        }
    }

    /**
     * helper function to swap nodes in array
     * @param A input array
     * @param left
     * @param right
     */
    public void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
