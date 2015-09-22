import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by adamli on 9/21/15.
 */
public class Binary_Tree_Level_Order_Traversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // create result arraylist
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        // create a queue of treenodes to traverse through the whole tree
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        // add root into queue using offer method
        queue.offer(root);

        // loop through the whole queue
        while (!queue.isEmpty()) {
            // create an arraylist of integers to save all value in the same level
            // level Arraylist got refreshed in every level
            ArrayList<Integer> level = new ArrayList<Integer>();

            // RECORD THE SIZE OF THE QUEUE (NUMBER OF NODES IN PREVIOUS LEVEL) BEFORE FOR LOOP
            int size = queue.size();

            /**
             * go through all treenodes in previous level one by one
             * size of the queue is the number of treenodes in last level
             * DO NOT USE I < QUEUE.SIZE() BECAUSE SIZE OF THE QUEUE KEEPS CHANGING IN FOR LOOP
             */
            for (int i=0; i < size; i++) {
                // pop the node out out queue to guarantee  it doesn't go to queue of next level
                TreeNode head = queue.poll();

                // add head nodes's value into current level ArrayList
                level.add(head.val);

                // if head node has a left child, add it into queue of the next level
                if (head.left != null) {
                    queue.offer(head.left);
                }

                // same with right node
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            // after the for loop, all values of previous level should be added into level
            // add level into result
            result.add(level);
        }

        return result;
    }
}
