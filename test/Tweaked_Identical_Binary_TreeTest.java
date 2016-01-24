import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adamli on 1/19/16.
 */
public class Tweaked_Identical_Binary_TreeTest {
    Tweaked_Identical_Binary_Tree sol = new Tweaked_Identical_Binary_Tree();

    @Test
         public void testIsTweakedIdentical1() throws Exception {
        String a[] = {"1","2","3","4"};
        String b[] = {"1","3","4","#","#","#","2"};

        TreeNode A = TreeUtil.getRoot(a);
        TreeNode B = TreeUtil.getRoot(b);

        boolean actual = sol.isTweakedIdentical(A, B);

        boolean expected = false;

        assertEquals(expected, actual);
    }

    @Test
    public void testIsTweakedIdentical2() throws Exception {
        String a[] = {"1","2","3","4","5","6","7"};
        String b[] = {"1","2","3","7","6","5","4"};

        TreeNode A = TreeUtil.getRoot(a);
        TreeNode B = TreeUtil.getRoot(b);

        boolean actual = sol.isTweakedIdentical(A, B);

        boolean expected = true;

        assertEquals(expected, actual);
    }
}