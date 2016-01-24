import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 1/15/16.
 */
public class Binary_Tree_Path_Sum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        List<Integer> path = new ArrayList<Integer>();

        helper(root, path, rst, 0, target);

        return rst;
    }

    public void helper(TreeNode root, List<Integer> path, List<List<Integer>> rst,
                       int sum, int target) {
        if (root == null)
            return;

        path.add(root.val);
        sum += root.val;

        if(sum == target) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }

        helper(root.left, path, rst, sum, target);
        helper(root.right, path, rst, sum, target);

        path.remove(path.size()-1);
        sum -= root.val;
    }
}
