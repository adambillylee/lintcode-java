/**
 * Created by adamli on 10/1/15.
 */
public class Remove_Duplicates_from_Sorted_List_II {
    /**
     * @param head head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            /**
             * since we have to keep head before the nodes to be deleted
             * we always check the head.next.val and head.next.next.val
             * in order to keep head at "previous node"
             */
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;

                /**
                 * now head is at "previous position"
                 * move head.next to the end of duplicate train
                 * at the end of while loop, head.next.val != val
                 */
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }

            }else{
                /**
                 * if no dups found, head = head.next
                 */
                head = head.next;
            }
        }

        return dummy.next;
    }
}
