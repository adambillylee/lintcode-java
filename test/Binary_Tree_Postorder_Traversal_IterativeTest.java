import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/25/16.
 */
public class Binary_Tree_Postorder_Traversal_IterativeTest {
    Binary_Tree_Postorder_Traversal_Iterative sol = new Binary_Tree_Postorder_Traversal_Iterative();

    @Test
    public void testPostorderTraversal() throws Exception {
        String input[] = {"1","2","3","4","5","6","7"};

        TreeNode root = TreeUtil.getRoot(input);

        ArrayList<Integer> actual = sol.postorderTraversal(root);
        System.out.println();
    }
}