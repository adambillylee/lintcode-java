import java.util.ArrayList;

/**
 * Created by adamli on 1/24/16.
 */
public class Binary_Tree_Postorder_Traversal_recursive {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();

        helper(root, rst);

        return rst;
    }

    public void helper(TreeNode root, ArrayList<Integer> rst) {
        if (root == null)
            return;

        helper(root.left, rst);
        helper(root.right, rst);
        rst.add(root.val);
    }
}
