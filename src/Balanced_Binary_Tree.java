/**
 * Created by adamli on 9/16/15.
 */
public class Balanced_Binary_Tree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        boolean result = true;

        if (maxDepth(root) == -1)
            result = false;

        return result;
    }

    /**
     * return depth of a balanced tree, if tree not balanced, return -1
     * @param root root node of target tree
     * @return  max path of target tree (could be depth of left or right tree)
     */
    private int maxDepth(TreeNode root){
        // if target tree is null, return depth = 0
        if (root == null)
            return 0;

        // divide
        // recursively calculate depth of left and right tree
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        /**
         * under 3 cases the target tree will not be a balanced tree:
         * 1. left tree is not balanced (depth left = -1)
         * 2. right tree is not balanced (depth right = -1)
         * 3. difference between left depth and right depth > 1 (def of balanced tree)
         * if target tree is not balanced, return -1
         */
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        // conquer:
        // return the maximum of left depth and right depth + 1 (depth of current root)
        return Math.max(left, right) + 1;
    }
}
