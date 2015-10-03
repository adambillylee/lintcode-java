/**
 * Created by adamli on 10/1/15.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree_With_Minimal_Height {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        // inplace BST building
        TreeNode node = buildTree(A, 0, A.length-1);
        return node;
    }

    /**
     *
     * @param A array of numbers
     * @param start start index of A
     * @param end end index of A
     * @return root node of tree built from A
     */
    public TreeNode buildTree (int[] A, int start, int end) {
        /**
         * base case: when there is no number in array left (from A[start~end] and start > end)
         * the final "tree" is null
         */
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A[mid]);

        /**
         * left tree node end with mid-1
         */
        node.left = buildTree(A, start, mid-1);

        /**
         * right tree node start with mid+1
         */
        node.right = buildTree(A, mid+1, end);

        /**
         * when all left and right tree finished
         * return middle node
         */
        return node;
    }
}
