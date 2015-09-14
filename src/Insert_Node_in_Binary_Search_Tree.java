/**
 * Created by adamlee on 15-09-12.
 */
public class Insert_Node_in_Binary_Search_Tree {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // base case: if root is a empty tree, return node
        if (root == null)
            return node;

        // binary search tree, left > node > right
        // so check left first
        if (root.val > node.val) {
            // the left tree become the left tree after node inserted
            root.left = insertNode(root.left, node);
        }else {
            // the right tree become the right tree after node inserted
            root.right = insertNode(root.right,node);
        }

        // backtrack: return root directly
        return root;
    }
}
