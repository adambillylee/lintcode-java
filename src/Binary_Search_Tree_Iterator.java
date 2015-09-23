import java.util.Stack;

/**
 * Created by adamli on 9/23/15.
 */
public class Binary_Search_Tree_Iterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curr;

    //@param root: The root of binary tree.
    public Binary_Search_Tree_Iterator(TreeNode root) {
        curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // if current node is null stack is empty
        return curr != null || !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        /**
         * in order: left root right
         * push nodes from current node down to the lowest left leaf to stack
         */
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        // pop the very first node from stack and return
        curr = stack.pop();
        TreeNode node = curr;

        /**
         * since stack is empty, all left node of current node is already iterated
         * go to right child of current node
         */
        curr = curr.right;

        return node;
    }
}
