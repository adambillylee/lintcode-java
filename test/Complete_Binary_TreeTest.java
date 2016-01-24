import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/21/16.
 */
public class Complete_Binary_TreeTest {
    Complete_Binary_Tree sol = new Complete_Binary_Tree();

    @Test
    public void testIsComplete1() throws Exception {
        String[] input = {"1","2","3","","4"};
        TreeNode root = TreeUtil.getRoot(input);
        boolean actual = sol.isComplete(root);
        boolean expected = false;

        assertEquals(actual, expected);
    }

    @Test
    public void testIsComplete2() throws Exception {
        String[] input = {"1","2","3","4","5","6","7","8","9","10","11","12","","13"};
        TreeNode root = TreeUtil.getRoot(input);
        boolean actual = sol.isComplete(root);
        boolean expected = false;

        assertEquals(actual, expected);
    }
}