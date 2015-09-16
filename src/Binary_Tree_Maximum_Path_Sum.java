/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

/**
 * define a return type class
 * for each recursion layer, store its singlePath and maxPath
 */
class ReturnType_Binary_Tree_Maximum_Path_Sum {
    int singlePath;
    int maxPath;

    ReturnType_Binary_Tree_Maximum_Path_Sum(int singlePath, int maxPath){
        // max path sum from root to any node, could be 0 nodes since max single path could be (stay at root)
        this.singlePath = singlePath;

        // max path sum in tree from anynode to anynode, must have at least 1 node (from node A to node B)
        // cannot be (stay at root)
        this.maxPath = maxPath;
    }
}

public class Binary_Tree_Maximum_Path_Sum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        ReturnType_Binary_Tree_Maximum_Path_Sum result = helper(root);
        return result.maxPath;
    }

    public ReturnType_Binary_Tree_Maximum_Path_Sum helper(TreeNode root) {
        if (root == null)
            /**
             * ReturnType_Binary_Tree_Maximum_Path_Sum(int singlePath, int maxPath)
             * null root has no single path, and max path are reset to be Integer.MIN_VALUE
             * to be refreshed later
             */
            return new ReturnType_Binary_Tree_Maximum_Path_Sum(0, Integer.MIN_VALUE);

        // divide
        ReturnType_Binary_Tree_Maximum_Path_Sum left = helper(root.left);
        ReturnType_Binary_Tree_Maximum_Path_Sum right = helper(root.right);

        /**
         * calculate singlePath (from top root to given root)
         * take max singlePath to left or right, and add value of given root
         */
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        /**
         * when root.val is less than 0, singlePath is 0
         * which means, don't move
         */
        singlePath = Math.max(0, singlePath);

        /**
         * calculate max path, could be in left tree or in right tree
         * max path could be from max path sum (from root to any point in left tree, or to any point in right tree)
         * OR, the current maxPath (since node value can be 0)
         */
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ReturnType_Binary_Tree_Maximum_Path_Sum(singlePath, maxPath);
    }
}