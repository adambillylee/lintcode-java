import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> actual = sol.postorderTraversal(root);

        for (Integer a : actual) {
            System.out.println(a);
        }
    }
}