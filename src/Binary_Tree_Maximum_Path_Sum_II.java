/**
 * Created by adamli on 11/11/15.
 */
public class Binary_Tree_Maximum_Path_Sum_II {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null)
            return 0;

        // call helper function
        return helper(root, 0);
    }

    public int helper(TreeNode root, int pathSum) {
        // base case: when root is null (one step further than leaf)
        if (root == null) {
            return pathSum;
        }

        // update date current pathSum
        pathSum += root.val;

        // divide
        int left = helper(root.left, pathSum);
        int right = helper(root.right, pathSum);

        // conquer
        return Math.max(left, right);
    }
}
