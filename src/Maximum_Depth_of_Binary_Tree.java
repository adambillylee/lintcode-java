/**
 * Created by adamlee on 15-09-12.
 */
public class Maximum_Depth_of_Binary_Tree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // base case, when at the empty tree, return depth = 0
        if (root == null) {
            return 0;
        }

        // divide tree into left and right
        // recursive call on both left an right
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // if a tree has left and right, that mean it has depth of 1
        // add depth = depth + 1 and backtrack
        return Math.max(left, right) + 1;
    }

}
