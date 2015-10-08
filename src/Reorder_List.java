/**
 * Created by adamli on 10/7/15.
 * find mid, reverse [mid~end]
 * merge [head~mid-1], [mid~end]
 */
public class Reorder_List {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        if (head.next == null)
            return;

        // find middle node
        ListNode mid = findMid(head);

        //reverse [mid+1~end]
        ListNode reverseHead = reverseList(mid.next);

        //cut original linkedlist to [start~mid]
        mid.next = null;

        // merge [start~mid], reverse[mid+1, end]
        mergeList(head, reverseHead);
    }

    /**
     * find the middle node of linked list
     * @param head
     * @return
     */
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * reverse linked list
     * @param head head node of linked list to be reversed
     * @return head node of reversed linked list
     */
    public ListNode reverseList(ListNode head) {

        /**
         * using 3 pointer for pre, current and post node
         */
        ListNode pre = null;

        while(head != null) {
            /**
             * use post pointer to record the next node
             * so after head.next is flipped
             * head can still goto next node
             */
            ListNode post = head.next;

            // flip head.next to previous node
            head.next = pre;

            // move pre and head point forward
            pre = head;
            head = post;
        } //after while loop, head pointer will be at null position

        // pre pointer will be at the starting node of reversed list
        return pre;
    }

    public void mergeList(ListNode headA, ListNode headB) {
        int index = 0;
        ListNode dummy = new ListNode(0);

        while(headA != null && headB != null) {
            if (index%2 == 0) {
                dummy.next = headA;
                headA = headA.next;
            }else {
                dummy.next = headB;
                headB = headB.next;
            }
            dummy = dummy.next;
            index++;
        }

        while (headA != null) {
            dummy.next = headA;
            headA = headA.next;
            dummy = dummy.next;
        }

        while (headB != null) {
            dummy.next = headB;
            headB = headB.next;
            dummy = dummy.next;
        }

        dummy.next = null;
    }
}
