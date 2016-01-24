import org.junit.Test;

import java.util.List;

/**
 * Created by adamli on 1/15/16.
 */
public class Binary_Tree_Path_SumTest {
    Binary_Tree_Path_Sum sol = new Binary_Tree_Path_Sum();

    @Test
    public void testBinaryTreePathSum() throws Exception {
        String input[] = {"1", "2", "4", "2", "3"};
        int target = 5;

        TreeNode root = TreeUtil.getRoot(input);

        List<List<Integer>> actual = sol.binaryTreePathSum(root, target);

        System.out.println();
    }


}