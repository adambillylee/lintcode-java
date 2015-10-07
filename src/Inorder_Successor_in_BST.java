/**
 * Created by adamli on 10/6/15.
 */
public class Inorder_Successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        /**
         * move root cursor to target node
         */
        while (p.val != root.val && root != null) {
            /**
             * binary search approach, if target is bigger than node, go right
             */
            if (p.val > root.val) {
                root = root.right;
            }else {
                /**
                 * if target is smaller than node, go left
                 * in inorder traversal, if you go to left node, than the successor of this left node will be
                 * the previous root node, so whenever root cursor goes left, keep track of previous root location
                 * as successor
                 */
                successor = root;
                root = root.left;
            }
        }

        /**
         * after root cursor at target node
         * 3 cases
         * 1. root == null, that means target cannot be found
         */
        if (root == null)
            return null;

        /**
         * 2. if target doesn't have right tree
         * return successor directly
         */
        if (root.right == null)
            return successor;

        /**
         * 3, if target still have right tree
         * then successor is the very left node in right tree
         * starting from moving root to its right tree:
         */
        root = root.right;

        // use a while loop to find the very left node in this right tree
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
