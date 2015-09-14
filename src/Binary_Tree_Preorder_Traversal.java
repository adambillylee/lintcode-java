import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by adamlee on 15-09-12.
 */
public class Binary_Tree_Preorder_Traversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        //divide, recusive call into root.left and root.right
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        // conquer, add root.val, left, right into result one by one
        result.add(root.val);
        result.addAll(left);    // use addAll to add whole arraylist
        result.addAll(right);   // use addAll to add whole arraylist

        return result;
    }
}
