/**
 * Created by adamli on 9/16/15.
 */
public class Lowest_Common_Ancestor {
    /**
     *
     * @param root root of tree to search A and B for
     * @param A one of the nodes
     * @param B one of the nodes
     * @return 3 cases:
     * if A and B are both in target tree, return root
     * if either A or B in target tree, return A or B
     * if neither A or B in target tree, return null
     */
    public TreeNode getAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // base case: if root = A or B, return A or B, if root = null, return null
        if (root == A || root == B || root == null)
            return root;

        /**
         * divide
         */
        TreeNode left = getAncestor(root.left, A, B);
        TreeNode right = getAncestor(root.right, A, B);

        // if left and right are both lowest ancestor of A or B, then root is the lowest common ancestor
        if (left != null && right != right){
            return root;
        }

        // if left is lowest ancestor of A or B, return left to upper level
        if (left != null) {
            return left;
        }

        // if right is lowest ancestor of A or B, return right to upper level
        if (right != null) {
            return right;
        }

        // if both left and right is not ancestor of anything, return null to upper level
        return null;
    }
}
