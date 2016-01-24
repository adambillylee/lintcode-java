import java.util.ArrayList;

/**
 * Created by adamli on 12/3/15.
 */
public class TreeUtil {
    private static int index = 0;

    public static TreeNode getRoot(String[] array) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i=0; i<array.length; i++)
            list.add(array[i]);

        return getRoot(list);
    }

    public static TreeNode getRoot(ArrayList<String> list) {
        // example {1,2,3,#,5,#,7}
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        index++;

        setNodes(root, list);

        return root;
    }

    public static void setNodes(TreeNode curr, ArrayList<String> list) {
        if (index >= list.size() || curr == null)
            return;

        curr.left = createTreeNode(list);
        index++;

        curr.right = createTreeNode(list);
        index++;

        setNodes(curr.left, list);
        setNodes(curr.right, list);
    }

    public static TreeNode createTreeNode(ArrayList<String> list) {
        if (index >= list.size())
            return null;

        if (!list.get(index).isEmpty()) {
            int val = Integer.valueOf(list.get(index));
            return new TreeNode(val);
        }

        return null;
    }
}
