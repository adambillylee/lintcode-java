/**
 * Created by adamli on 1/28/16.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);

        return root;
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd) {

        if (inStart > inEnd)
            return null;

        if (poStart > poEnd)
            return null;

        TreeNode root = new TreeNode(postorder[poEnd]);

        // find index of root in inorder array
        int rootInIn = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if (inorder[i] == postorder[poEnd]) {
                rootInIn = i;
                break;
            }
        }

        /**
         * left tree:
         * in inorder array: start with inStart, ends at rootInIn-1
         * in postorder array: start with poStart, ends with poStart + (length of left) -1
         */
        TreeNode left = helper(inorder, postorder, inStart, rootInIn-1, poStart, poStart + (rootInIn - inStart)-1);

        /**
         * right tree:
         * in inorder array: start with rootInIn+1, ends at inEnd
         * in postorder array: start with poStart + (length of left tree), ends at (root index in postorder array) -1
         */
        TreeNode right = helper(inorder, postorder, rootInIn+1, inEnd, poStart + (rootInIn - inStart), poEnd-1);

        root.left = left;
        root.right = right;

        return root;
    }
}
