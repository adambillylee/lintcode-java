/**
 * Created by adamli on 9/13/15.
 */
class ReturnType {
    boolean isBST;
    int maxValue, minValue;

    ReturnType(Boolean isBST, int maxValue, int minValue){
        this.isBST = isBST;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}


public class Validate_Binary_Search_Tree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        ReturnType result = helper(root);
        return result.isBST;
    }

    /**
     *
     * @param root
     * @return
     */
    public ReturnType helper(TreeNode root) {
        // base case: if root is null, return isBST=true, min = Integer.MIN and max = Integer.max
        if (root == null)
            /**
             * new ReturnType(isBST, max, min)
             * when root is null, reset max = Integer.MIN_VALUE, min = Integer.MAX_VALUE
             * so any root.val that comes after can refresh this value
             */
            return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // divide
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        // if left or right tree is not BST, than return isBST=false, max and min doesn't matter
        if (!left.isBST || !right.isBST)
            return new ReturnType(false, 0, 0);

        /**
         * if tree has a left tree, but root value is less than max value in left tree, return false
         * if tree has a right tree, but root value is greater than min value of right tree, return false
         */
        if (root.left != null && left.maxValue >= root.val ||
                root.right != null && right.minValue <= root.val)
            return new ReturnType(false, 0, 0);


        /**
         * refresh max value when right tree is null
         * when right tree is null, right.maxValue = Integer.MIN_VALUE as per reset above
         * so use root value to refresh right.maxValue for its parent tree after backtrack
         */
        int max = Math.max(root.val, right.maxValue);

        /**
         * refresh min value when left tree is null
         * when left tree is null, left.minValue = Integer.MAX_VALUE as per reset above
         * so use root value to refresh left.minValue for its parent tree after backtrack
         */
        int min = Math.min(root.val, left.minValue);

        return new ReturnType(true, max, min);
    }
}
