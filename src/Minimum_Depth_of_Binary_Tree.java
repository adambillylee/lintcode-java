/**
 * Created by adamli on 1/24/16.
 */
public class Minimum_Depth_of_Binary_Tree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // special case: if root is null, return 0
        if (root == null)
            return 0;

        return helper(root);
    }

    /**
     * select the min depth from EXISTING left and right
     * but don't select the branch with null
     */
    public int helper(TreeNode root) {
        /** when current node is null, set return max int to
         * make sure this branch is not selected
         */
        if (root == null)
            return Integer.MAX_VALUE;

        /**
         * if current node has value but
         * both left and right node empty
         * return 1 as depth add of current node
         * since left and right both cannot be selected
         */
        if (root.left == null && root.right == null)
            return 1;

        // divide
        int left = helper(root.left);
        int right = helper(root.right);

        /**
         * select min depth from left and right as
         * min depth, add 1 as current level depth
         */
        return Math.min(left, right) + 1;
    }
}
