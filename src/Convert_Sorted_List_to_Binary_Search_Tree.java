import java.util.LinkedList;

/**
 * Created by adamli on 10/1/15.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    /**
     * define an static listnode pointer to keep track of position
     * across all recursive calls
     */
    static ListNode curr;

    /**
     *
     * @param head head of the linked list to get length with
     * @return length of the linked list
     */
    public int getLength(ListNode head) {
        if (head == null)
            return 0;

        int length = 0;

        while (head != null) {
            head = head.next;
            length ++;
        }

        return length;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);

        // start curr pointer at head
        curr = head;

        TreeNode node = buildTree(0, length-1);

        return node;
    }

    public TreeNode buildTree(int start, int end) {
        /**
         * base case: when start > end
         * all numbers are already being used in linked list
         * return null as leaf of the tree
         */
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode left = buildTree(start, mid-1);
        TreeNode node = new TreeNode(curr.val);

        /**
         * after each treenode is created from linked list, move curr forward
         * "this linked list node is already used"
         */
        curr = curr.next;

        /**
         * after left and node is build, the curr will be at the position where right tree starts
         */
        TreeNode right = buildTree(mid+1, end);


        // connect left right with node
        node.left = left;
        node.right = right;

        return node;
    }
}
