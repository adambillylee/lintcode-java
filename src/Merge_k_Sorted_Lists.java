import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by adamli on 10/6/15.
 */
public class Merge_k_Sorted_Lists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKListsHeap(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        /**
         * use heap to sort all nodes from all lists
         */
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);

        // push the head of all nodes in to heap as initialization
        for (int i=0; i<lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        // create dummy node and pointer to construct new merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        /**
         * use heap to pop min node of all lists (O(1))
         * use tail pointer to add node into merged list, REMEMBER TO MOVE IT FORWARD FOR NEXT INSERTION
         * add the next node of min node into heap, for next round of comparison
         * continue until all nodes from all lists are added to heap -> poped from heap and added into merged list
         */
        while(!heap.isEmpty()) {
            // pop the min value in queue as next value of merged list
            ListNode head = heap.poll();
            tail.next = head;

            // move pointer forward to prepare for next insertion
            tail = tail.next;

            // get the next node from the lists and continue comparing
            if (head.next != null) {
                heap.add(head.next);
            }
        }

        // return the first node of merged list
        return dummy.next;
    }

    /**
     * define a ListNode comparator
     * if its an increasing list, use left-right
     */
    private Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
}
