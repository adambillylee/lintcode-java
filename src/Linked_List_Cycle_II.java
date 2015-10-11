import java.util.LinkedList;

/**
 * Created by adamli on 10/10/15.
 */
public class Linked_List_Cycle_II {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     * if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        // first, figure out is there a loop or not
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            /**
             * if there is a loop, there will always space
             * for fast to loop around and hit slow
             */
            if (fast.next == null || fast.next.next == null)
                return null;

            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * OK, so there is a loop
         * keep moving head and slow forward (by one node)
         * head = slow.next where head loop around at first node and slow is at last
         */
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
