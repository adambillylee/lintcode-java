import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by adamli on 12/3/15.
 */
public class TreeUtilTest {
    @Test
    public void testGetRoot() throws Exception {
        String[] input = {"1","2","3","","5"};

        ArrayList<String> list =
                new ArrayList<String>(Arrays.asList(input));

        TreeNode actualRoot = TreeUtil.getRoot(list);

        // construct expecte tree
        TreeNode expectRoot = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        expectRoot.left = node2;
        expectRoot.right = node3;
        node2.right = node5;

        // Define comparitor
        Comparator<TreeNode> comparator = new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                ArrayList l1 = inOrderTraversal(o1);
                ArrayList l2 = inOrderTraversal(o2);

                if (l1.equals(l2)){
                    return 0;
                }else{
                    return -1;
                }
            }
        };

        assertTrue("not equal", comparator.compare(actualRoot, expectRoot)==0);
    }

    public ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        helper(root, rst);

        return rst;
    }

    public void helper(TreeNode root, ArrayList<Integer> rst) {
        if (root == null)
            return;

        helper(root.left, rst);
        rst.add(root.val);
        helper(root.right, rst);
    }

}