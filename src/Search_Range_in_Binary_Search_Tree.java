import java.util.ArrayList;

/**
 * Created by adamli on 9/21/15.
 */
public class Search_Range_in_Binary_Search_Tree {
    private ArrayList<Integer> result;
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        result = new ArrayList<Integer>();
        helper(root, k1, k2);
        return result;
    }

    public void helper (TreeNode root, int k1, int k2) {
        // if root is null, quit
        if (root == null)
            return;

        // if k1 < root.val, then range must be in left tree
        if (k1 < root.val)
            helper(root.left, k1, k2);

        // if k1 <= root.val <= k2, then root value is a result we are looking for, add it into result
        if (root.val >= k1 && root.val <= k2)
            result.add(root.val);

        // since if root.val <= k2, k2 > root.val, so the search will continue to right tree
        // if k2 > root.val, search range must be in right tree
        if (k2 > root.val)
            helper(root.right, k1, k2);
    }
}
