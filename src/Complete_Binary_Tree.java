import java.util.*;

/**
 * Created by adamli on 1/21/16.
 */
public class Complete_Binary_Tree {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // empty tree is complete tree
        if (root == null)
            return true;

        // define a queue for bst
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        // initiate queue with root node
        queue.offer(root);

        /**
         * the first node that has empty child node is the last root
         * in complete binary tree, any node after that should not have
         * any child node
         */
        boolean isLastRoot = false;

        // bst
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            /**
             * if last root in tree already appeared and node after still have
             * child, return false
             */
            if (isLastRoot == true && (node.left != null || node.right != null))
                return false;

            /**
             * for "last root in complete tree", if left child is empty
             * but right is not, return false (as left as possible)
             */
            if (node.left == null && node.right != null)
                return false;

            // standard bst: add left node if exists into queue
            if (node.left != null)
                queue.offer(node.left);

            // standard bst, add right node if exists into queue
            if (node.right != null)
                queue.offer(node.right);

            /**
             * if any child is null, current node is "last root in complete
             * binary tree"
             */
            if (node.left == null || node.right == null)
                isLastRoot = true;
        }

        return true;
    }
}
